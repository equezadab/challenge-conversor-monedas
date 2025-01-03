# Conversor de Monedas

Este es un proyecto de un Conversor de Monedas creado por Alura Latam que permite realizar conversiones entre diferentes monedas utilizando una API externa para obtener las tasas de cambio en tiempo real. Además, guarda un historial de las conversiones realizadas en un archivo historial.json para su posterior consulta.

## Funcionalidades
* Conversión de monedas entre:
* Dólar estadounidense (USD) a Peso Argentino (ARS)
* Peso Argentino (ARS) a Dólar estadounidense (USD)
* Dólar estadounidense (USD) a Real Brasileño (BRL)
* Real Brasileño (BRL) a Dólar estadounidense (USD)
* Dólar estadounidense (USD) a Peso Colombiano (COP)
* Peso Colombiano (COP) a Dólar estadounidense (USD)
* Historial de Conversiones: El programa guarda un historial de todas las conversiones realizadas y lo almacena en un archivo JSON llamado historial.json.
* Opción de ver el historial de conversiones en un archivo llamado historial.json que se crea en el directorio del proyecto.

## Requisitos
- Java 21: Este proyecto utiliza Java 21, por lo que necesitarás tenerlo instalado.
- API de Exchange Rate: El proyecto hace uso de la API ExchangeRate-API para obtener las tasas de conversión. Necesitarás una API Key que debes agregar en el archivo ApiService.java.
