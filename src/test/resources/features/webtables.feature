@Webtables
Feature: Configuración de Web Tables
  Como un usuario la pagina ToolsQa
  Quiero configurar registros de personas en una tabla web
  Para mantener mi información organizada

  @Prueba
  Scenario: Agregar registro con datos correctos en la tabla web
    Given que el usuario ingresa a la pagina demoqa para interactuar con una tabla web
    When registra información solicitada en la tabla
    Then el puede agregar el registro en la tabla

  @Prueba1
  Scenario: Eliminar registro en la tabla web
    Given que el usuario ingresa a la pagina demoqa para interactuar con una tabla web
    When selecciona el registro a eliminar
    Then el puede eliminar el registro
