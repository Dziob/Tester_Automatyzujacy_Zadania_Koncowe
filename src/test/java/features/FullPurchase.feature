Feature: Składanie zamówienia
  Scenario Outline: Składanie zamówienia oraz sprawdzenie jego poprawnego zapisania
  Given Użytkownik znajduje się na stronie głownej my 'store'
  When Wybiera opcję 'sing in' i loguje się porawnymi danymi
  And Użytkownik przechodzi do zakładki clothes
  And Wybiera 'Hummingbird Printed Sweater'
  And Sprawdza czy rabat na produkt wynosi 20%
  And Wybiera "<rozmiar>" i "<iloscSztuk>" produktu i dodaje go do koszyka
  And Przechodzi do koszyka poprzez opcję 'Proced to checkout' i potwierdza koszyk
  And Użytkownik potwierdza adres, wybiera metodę odbioru - PrestaShop 'pick up in store', wybiera opcję płatności - Pay by Check
  And Uzytkownik zatwierdza regulamin i wybiera 'Place order'
  Then Użytkownik wykonuje zrzut ekranu potwierdzający złożenie zamówienia
  And Użytkownik przechodzi do swojego konta a następnie wybiera historię zamówień
  And Użytkownik potwierdza,że zamówienie ma status 'Awaiting check payment' oraz, że podana tu kwota jest taka sama jak przy składaniu zamówienia
  And Użytkownik wyloguje się i wyłączy przeglądarkę


  Examples:
  |rozmiar|iloscSztuk|
  |M      |5         |