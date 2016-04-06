@ImageSearch
Feature: Como usuario
  Quiere poder hacer búsquedas por imágenes
  Que me lleven a la información que estoy buscando

  Scenario Outline: Busqueda de información con diferentes imágenes
    Given Busco imagen por el "<texto>"
    When navego hasta la imagen "<posicionImagen>"
    Then llego a la "<web>" deseada
    Examples:
      | texto                      | posicionImagen | web                                                                                                  |
      | Exploratory testing chrome | 3              | https://chrome.google.com/webstore/detail/exploratory-testing-chrom/khigmghadjljgjpamimgjjmpmlbgmekj |
      | epi gijon                  | 2              | https://twitter.com/epigijon                                                                         |