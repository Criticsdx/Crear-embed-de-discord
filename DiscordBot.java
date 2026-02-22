import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.awt.Color;
import java.time.Instant;

/**
 * Bot de Discord con sistema de embeds
 * Cualquiera puede crear embeds usando el comando #embed
 * 
 * Uso: #embed titulo | descripcion | color(hex)
 * Ejemplos:
 * #embed Mi Titulo | Esta es la descripcion | #FF5733
 * #embed Anuncio | Hoy hay evento a las 8pm
 * #embed Hola Mundo
 */
public class DiscordBot extends ListenerAdapter {
    private static final String PREFIX = "#";

    public static void main(String[] args) throws Exception {
        String token = System.getenv("DISCORD_BOT_TOKEN");

        if (token == null || token.isEmpty()) {
            token = "";
            System.out.println("Advertencia: Usando token hardcodeado. Considera usar variables de entorno.");
        }

        JDA jda = JDABuilder.createDefault(token)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES)
                .addEventListeners(new DiscordBot())
                .build();

        jda.awaitReady();
        System.out.println("Bot conectado como: " + jda.getSelfUser().getName());
        System.out.println("Usa " + PREFIX + "help para ver los comandos disponibles");
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot())
            return;

        String message = event.getMessage().getContentRaw();

        // Comando: #embed - Cualquier usuario puede crear un embed
        // Formato: #embed titulo | descripcion | #colorHex
        if (message.toLowerCase().startsWith(PREFIX + "embed")) {
            String content = message.substring((PREFIX + "embed").length()).trim();

            // Si no escribió nada después de #embed, mostrar instrucciones
            if (content.isEmpty()) {
                event.getChannel().sendMessageEmbeds(createUsageEmbed()).queue();
                return;
            }

            // Parsear: titulo | descripcion | color
            String[] parts = content.split("\\|");
            String titulo = parts[0].trim();
            String descripcion = parts.length > 1 ? parts[1].trim() : "";
            String colorHex = parts.length > 2 ? parts[2].trim() : "";

            // Crear el embed personalizado
            MessageEmbed embed = createCustomEmbed(titulo, descripcion, colorHex, event);
            event.getChannel().sendMessageEmbeds(embed).queue();

            // Borrar el mensaje del comando del usuario (opcional, si tiene permisos)
            try {
                event.getMessage().delete().queue(success -> {
                }, error -> {
                });
            } catch (Exception ignored) {
            }
        }

        // Comando: #help - Muestra ayuda
        else if (message.equalsIgnoreCase(PREFIX + "help")) {
            MessageEmbed helpEmbed = createHelpEmbed();
            event.getChannel().sendMessageEmbeds(helpEmbed).queue();
        }

        // Comando: #info - Información del bot
        else if (message.equalsIgnoreCase(PREFIX + "info")) {
            MessageEmbed infoEmbed = createInfoEmbed(event.getJDA());
            event.getChannel().sendMessageEmbeds(infoEmbed).queue();
        }

        // Comando: #ping - Verifica latencia
        else if (message.equalsIgnoreCase(PREFIX + "ping")) {
            long ping = event.getJDA().getGatewayPing();
            event.getChannel().sendMessage("Pong! Latencia: " + ping + "ms").queue();
        }
    }

    /**
     * Crea un embed personalizado a partir de los datos del usuario
     */
    private MessageEmbed createCustomEmbed(String titulo, String descripcion, String colorHex,
            MessageReceivedEvent event) {
        EmbedBuilder embed = new EmbedBuilder();

        // Color: usar el proporcionado o uno por defecto
        Color color = parseColor(colorHex);
        embed.setColor(color);

        // Título
        embed.setTitle(titulo);

        // Descripción (si la hay w)
        if (!descripcion.isEmpty()) {
            embed.setDescription(descripcion);
        }

        // Footer con quien creó el embed
        embed.setFooter("Creado por " + event.getAuthor().getName(),
                event.getAuthor().getAvatarUrl());

        // Timestamp
        embed.setTimestamp(Instant.now());

        return embed.build();
    }

    /**
     * Parsea un color hex string a color, retorna azul por defecto si falla
     */
    private Color parseColor(String hex) {
        if (hex == null || hex.isEmpty()) {
            return new Color(88, 101, 242); // Discord Blurple por defecto
        }
        try {
            hex = hex.replace("#", "");
            return Color.decode("#" + hex);
        } catch (NumberFormatException e) {
            return new Color(88, 101, 242); // Discord Blurple por defecto
        }
    }

    /**
     * Embed de instrucciones cuando el usuario escribe solo #embed
     */
    private MessageEmbed createUsageEmbed() {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setColor(new Color(255, 165, 0)); // Naranja
        embed.setTitle("Como usar el comando embed");
        embed.setDescription("Crea embeds personalizados separando las partes con `|`");

        embed.addField("Formato",
                "`" + PREFIX + "embed titulo | descripción | #colorHex`", false);
        embed.addField("Ejemplos",
                "`" + PREFIX + "embed Anuncio | Hoy hay evento a las 8pm | #FF5733`\n" +
                        "`" + PREFIX + "embed Reglas del servidor | 1. Respeto 2. No spam`\n" +
                        "`" + PREFIX + "embed Bienvenidos`",
                false);
        embed.addField("Tip",
                "El color es opcional. Si no lo pones, se usa un color azul por defecto.", false);

        embed.setTimestamp(Instant.now());
        return embed.build();
    }

    /**
     * Crea el embed de ayuda
     */
    private MessageEmbed createHelpEmbed() {
        EmbedBuilder embed = new EmbedBuilder();

        embed.setColor(Color.BLUE);
        embed.setTitle("Comandos Disponibles");
        embed.setDescription("Lista de comandos que puedes usar:");

        embed.addField(PREFIX + "embed titulo | descripción | #color",
                "Crea un embed personalizado. Cualquiera puede usarlo.", false);
        embed.addField(PREFIX + "help", "Muestra este mensaje de ayuda", false);
        embed.addField(PREFIX + "info", "Información sobre el bot", false);
        embed.addField(PREFIX + "ping", "Verifica la latencia del bot", false);

        embed.setFooter("Usa los comandos con el prefijo " + PREFIX, null);
        embed.setTimestamp(Instant.now());

        return embed.build();
    }

    /**
     * Crea el embed de información del bot
     */
    private MessageEmbed createInfoEmbed(JDA jda) {
        EmbedBuilder embed = new EmbedBuilder();

        embed.setColor(Color.GREEN);
        embed.setTitle("Informacion del Bot");

        embed.addField("Nombre", jda.getSelfUser().getName(), true);
        embed.addField("ID", jda.getSelfUser().getId(), true);
        embed.addField("Servidores", String.valueOf(jda.getGuilds().size()), true);
        embed.addField("Latencia", jda.getGatewayPing() + "ms", true);
        embed.addField("Librería", "JDA 5.0.0", true);
        embed.addField("Lenguaje", "Java", true);

        embed.setThumbnail(jda.getSelfUser().getAvatarUrl());
        embed.setTimestamp(Instant.now());

        return embed.build();
    }
}
