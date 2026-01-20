# API Análisis de Sentimiento

API para analizar sentimiento a partir de texto. Expone el endpoint del backend y se integra con el servicio de Data Science (DS).

## Endpoints

### Backend
- `POST /sentiment`
  - **Request**
    ```json
    { "text": "El servicio fue excelente y llegó muy rápido" }
    ```
  - **Response OK**
    ```json
    { "prevision": "Positivo", "probabilidad": 0.87 }
    ```

## Integración con Data Science (DS)

El backend consume el servicio DS para obtener la predicción.

- **DS URL (configurable):** se define en `application.properties` mediante la propiedad:
  - `DS_BASE_URL` (variable/propiedad de configuración del servicio)

Ejemplos (ajusta según tu entorno):
- Qa: `curl --request POST \
  --url https://api-analis-sentieminto.yccweb.uk/api-analisis/sentiment \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: insomnia/11.3.0' \
  --data '{
  "text": "pésimo servicio"
  }	'`

> Nota: No se deben subir credenciales, tokens o keys al repositorio. Solo variables/propiedades de configuración.

## Registro de cambios

### 2026-01-07
- Ajuste en `DsClient`:
  - Se actualizó el cliente que consume el servicio de Data Science para dejar explícita la URL de conexión y mejorar el manejo de la integración.
- Ajuste en `application.properties`:
  - Se modificó configuración relacionada con el consumo del servicio DS (URL/propiedades) para alinear el comportamiento del backend.

## Ramas
- El trabajo se realiza en la rama: `develop`.
