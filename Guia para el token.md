# Cómo tener un Token válido del discord ggpapaff
## Pasos para Obtener el Token

### 1. Ve al Discord Developer Portal
[https://discord.com/developers/applications](https://discord.com/developers/applications)

### 2. Selecciona tu Aplicación
- Si ya tienes una aplicación, haz clic en ella
- Si no tienes ninguna, haz clic en **"New Application"**

### 3. Ve a la Sección "Bot"
- En el menú lateral izquierdo, haz clic en **"Bot"**
- Si no has creado un bot, haz clic en **"Add Bot"**

### 4. Copia el Token
- Busca la sección **"TOKEN"**
- Haz clic en **"Reset Token"** (esto generará un nuevo token)
- **IMPORTANTE**: Copia el token rapido, solo se muestra una vez
- El token se una mamada asi: `MTQ1ODAxMTMxMDM0MzMyNzc1NQ.GOm8Qy.ypJBNSJ4ngRzqS7G1WfWUQMpcMwJkAR-joo7pEI`

### 5. Activa los Intents Necesarios
En la misma página de "Bot", baja hasta **"Privileged Gateway Intents"** y activa:

-  **PRESENCE INTENT**
-  **SERVER MEMBERS INTENT**
- **MESSAGE CONTENT INTENT** ← Importante

Haz clic en **"Save Changes"**

### 6. Invita el Bot a tu Servidor
- Ve a **"OAuth2"** > **"URL Generator"**
- En **"SCOPES"**, selecciona:
  - `bot`
  - `applications.commands`
- En **"BOT PERMISSIONS"**, selecciona:
  -  Send Messages
  -  Embed Links
  -  Read Message History
  -  Use Slash Commands
- Copia la URL generada al final de la página
- Pégala en tu navegador y selecciona tu servidor

---

## Actualizar el Token en el Código

### Opción 1: Editar DiscordBot.java (Línea 26)

Abre `DiscordBot.java` y reemplaza el token en la línea 26:

```java
token = "TU_NUEVO_TOKEN_AQUI";
```

### Opción 2: Usar Variable de Entorno (Más Seguro)

```powershell
# En PowerShell
$env:DISCORD_BOT_TOKEN="TU_NUEVO_TOKEN_AQUI"
.\run.bat
```

---

## Ejecutar el Bot Nuevamente

Después de actualizar el token:

```bash
.\run.bat
```
Deberías ver:
```
Bot conectado como: [Nombre de tu bot]
Usa !help para ver los comandos disponibles
```

## Probar el Bot

1. Ve a tu servidor de Discord
2. En cualquier canal donde el bot tenga permisos, escribe:
   ```
   !embed
   ```
3. El bot debería responder con el embed de verificación con antivirus

---

## Notas de Seguridad

> **Nunca compartas el token publicamente**
> - El token da acceso completo a tu bot
> - Si alguien obtiene tu token, puede controlar tu bot
> - Si crees que tu token fue comprometido, regenera uno nuevo en el Developer Portal

---

## Solución de Problemas

### El bot no responde a los comandos
- Verifica que **MESSAGE CONTENT INTENT** esté activado
- Asegúrate de que el bot tenga permisos de "Send Messages" en el canal

### Error: "Missing Permissions"
- Ve a la configuración del servidor
- Roles --- Selecciona el rol del bot
- Activa los permisos necesarios

### El bot se desconecta constantemente
- Verifica la conexión a internet
- Asegúrate de que el token sea válido (Me paso 3 veces esa mierda Dx)