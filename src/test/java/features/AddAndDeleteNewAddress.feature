Feature: Dodawanie i usuwanie adresu
  Scenario Outline: Dodawanie nowego adresu do instniejacego konta a następnie usuwanie go
    Given Użytkownik znajduje się na stronie głównej sklepu
    When Wybiera opcję 'Sing in'
    And Loguje się za pomocą poprawnego loginu i hasła
    And Przechodzi do swojego konta, wybiera kafelek 'Addresses' a następnie opcję '+Create new address'
    And Wypełni pola "<alias>", "<address>", "<city>", "<zip>", "<country>", "<phone>" i zatwierdzi
    Then Użytkownik zostanie przekierowany do 'Your Adresses' i wyświetlony zostanie komunikat potwierdzający dodanie adresu
    And Użytkownik usuwa nowo utworzony adres
    And Wyświetlony zostaje komunikat o prawidłowym usunięciu
    And Użytkownik wylogowuje się i zamyka przeglądarkę

    Examples:
    |alias        |address    |city      |zip   |country       |phone|
    |MyTestAddress|Testowa 1/2|Miasteczko|12-345|United Kingdom|123456123|

  #Ze względu na to, że pierwszy dodany na stronię adres jest niemożliwy do usunięcia,
  # w ramach przygotowania do testu, manualnie utworzyłam na wykorzystywanym koncie jeden adres