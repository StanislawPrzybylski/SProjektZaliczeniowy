Feature: Dokonywanie zakupu przez zalogowanego uzytkownika
  Scenario Outline: Zalogowany uzytkownik wybiera produkt parametryzujac go, dokonuje zakupu i robi screenshota
    Given Niezalogowany uzytkownik znajduje się na stronie glownej aplikacji
    And Uzytkownik kilka przycisk signIn i loguje sie na strone danym adres "<email>" oraz haslo "<haslo>"
    And Uzytkownik przechodzi do strony mystore i wybiera produkt Hummingbird Printed Sweater
    And Uzytkownik sprawdza przecene
    When Wybiera rozmiar "<rozmiar>" produktu
    And Wybiera ilosc towaru i klika przycisk addToCart
    And Uzytkownik kilka procedure to checkout i ponawia ten krok na nowej stronie
    And Uzytkownik wepelnia formularz  swoimi danymi "<alias>", "<address>", "<city>", "<postalCode>", "<phone>" Kilka continue
    Then Uzytkownik wybiera i potwierdza rodzaj dostawy
    And Uzytkownik wybiera metode platnosci wyraza zgode z warunkami umowy i kilka Place Order
    And Wyswietla sie potwierdzenie zamowienia i uzytkownik robi screenshota
    And Przegladarka jest zamknieta
    Examples:
      |email|haslo|rozmiar|alias|address|city|postalCode|phone|
      |s.przybylski1988@gmail.com|qwerty666|L|Dzodzo|ul. Lawendowa|Kielczow|55093|504 918 544|
