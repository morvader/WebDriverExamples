@login
Feature:
  Como usuario
  Quiero un formulario de autenticación
  Para acceder a mi sección personal

  Scenario: No debe permitirse logarse a un usuario con credenciales incorrectas
    Given un usuario con credenciales incorrectas
    When intenta logarse
    Then se muestra un mensaje de error

  Scenario: Cuando un usuario con credeciales correctas se logue accede a su sección personal
    Given un usuario con credenciales correctas
    When intenta logarse
    Then accede a su seccion personal