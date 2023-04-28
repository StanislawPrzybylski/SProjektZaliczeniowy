Feature: Dodawanie adresu do swojego konta
  Scenario Outline: Dodawanie nowego adresu dla zalogowanego uzytkownika
    Given Uzytkownik znajduje się na stronie glownej aplikacji
    And Uzytkownik kilka przycisk signIn
    When Loguje sie poprawnymi danymi "<email>" oraz "<haslo>"
    And Zalogowany uzytkownik na stronie glownej kilka w Addresses na wyswietlonej stronie
    And Uzytkownik wybiera Creat new Address
    And Uzytkownik wepelnia formularz swoimi danymi "<alias>", "<address>", "<city>", "<postalCode>", "<phone>" Kilka zapisz
    Then Nowy adres zostaje dodany uzytkownik "<name>" "<lastname>" sprawdza poprawnosc danych "<alias>", "<address>", "<city>", "<postalCode>", "<phone>"
    And Przegladarka zostaje zamknieta

    Examples:
      |email|haslo|alias|address|city|postalCode|phone|name|lastname|
      |s.przybylski1988@gmail.com|qwerty666|Dzodzo|ul. Lawendowa|Kielczow|55093|504 981 544|Stachu|Przybylski|
