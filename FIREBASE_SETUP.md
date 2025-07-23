# Configuración de Firebase App Distribution

## Configuración requerida

Para que los GitHub Actions funcionen correctamente con Firebase App Distribution, necesitas configurar los siguientes secrets en tu repositorio de GitHub:

### 1. FIREBASE_APP_ID
Este es el ID de tu aplicación en Firebase. Lo puedes encontrar en:
- Ve a la [consola de Firebase](https://console.firebase.google.com/)
- Selecciona tu proyecto
- Ve a "Project Settings" > "General"
- En la sección "Your apps", copia el "App ID" de tu aplicación Android

### 2. CREDENTIAL_FILE_CONTENT
Este es el contenido del archivo de credenciales de servicio de Google Cloud:

1. Ve a la [consola de Google Cloud](https://console.cloud.google.com/)
2. Selecciona tu proyecto de Firebase
3. Ve a "IAM & Admin" > "Service Accounts"
4. Crea una nueva cuenta de servicio o usa una existente
5. Asigna el rol "Firebase App Distribution Admin"
6. Genera una nueva clave JSON privada
7. Copia todo el contenido del archivo JSON y pégalo como el valor del secret

### Configuración de Secrets en GitHub

1. Ve a tu repositorio en GitHub
2. Ve a "Settings" > "Secrets and variables" > "Actions"
3. Haz clic en "New repository secret"
4. Agrega los siguientes secrets:
   - Name: `FIREBASE_APP_ID`, Value: tu App ID de Firebase
   - Name: `CREDENTIAL_FILE_CONTENT`, Value: el contenido completo del archivo JSON de credenciales

### Configuración de grupos de testers

Por defecto, la distribución se envía al grupo "testers". Para configurar este grupo:

1. Ve a la [consola de Firebase](https://console.firebase.google.com/)
2. Selecciona tu proyecto
3. Ve a "App Distribution"
4. En la pestaña "Testers & Groups", crea un grupo llamado "testers"
5. Agrega las direcciones de email de los testers a este grupo

### Workflows disponibles

1. **release-please.yml**: Se ejecuta automáticamente cuando hay push a la rama main y crea releases. Cuando se crea un release, automáticamente distribuye el APK a Firebase App Distribution.

2. **firebase-app-distribution.yml**: Workflow independiente que se puede ejecutar:
   - Automáticamente cuando se publica un release
   - Manualmente desde la pestaña Actions de GitHub (permite agregar notas de release personalizadas)

### Personalización

Puedes personalizar los workflows modificando:
- El grupo de testers cambiando el valor de `groups` en los archivos YAML
- Las notas de release modificando el campo `releaseNotes`
- Los triggers modificando la sección `on` de cada workflow
