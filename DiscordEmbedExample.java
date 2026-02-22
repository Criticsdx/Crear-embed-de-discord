import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import java.awt.Color;
import java.time.Instant;

/**
 * Ejemplo de cómo crear embeds personalizados con el bot.
 * Este archivo es solo un ejemplo/referencia.
 * 
 * El bot principal (DiscordBot.java) permite que cualquier usuario cree embeds usando: #embed titulo | descripcion | #colorHex
 */
public class DiscordEmbedExample {

        public static void main(String[] args) throws Exception {
                JDA jda = JDABuilder.createDefault("TU_TOKEN_AQUI").build();
                jda.awaitReady();

                TextChannel channel = jda.getTextChannelById("ID_DEL_CANAL");

                if (channel != null) {
                        // Ejemplo: embed simple
                        MessageEmbed embed = createCustomEmbed(
                                        "Mi Embed Personalizado",
                                        "Esta es una descripción de ejemplo",
                                        new Color(88, 101, 242));
                        channel.sendMessageEmbeds(embed).queue();
                }
        }

        /**
         * Crea un embed personalizado con titulo, descripcion y color
         */
        public static MessageEmbed createCustomEmbed(String titulo, String descripcion, Color color) {
                EmbedBuilder embed = new EmbedBuilder();

                embed.setColor(color);
                embed.setTitle(titulo);
                embed.setDescription(descripcion);
                embed.setTimestamp(Instant.now());

                return embed.build();
        }
}
