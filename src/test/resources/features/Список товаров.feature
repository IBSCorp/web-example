# language: ru

# Тестовые данные:
  # $Наименование Банан
  # $Тип Фрукт
  # $Экзотический true

Функция: Список товаров

  Сценарий: Добавление нового товара

    * страница "Главная страница" загружена

    * выполнено нажатие на "Песочница"
    * нажатием на кнопку "Товары" загружена страница "Список товаров"
    * выполнено нажатие на "Песочница"
    * выполнено нажатие на "Сброс данных"
    * страница "Список товаров" загружена
    * количество элементов коллекции "Таблица" равно "4"
    * нажатием на кнопку "Добавить" загружена страница "Добавление товара"
    * заполняются поля:
      | field        | value           |
      | Наименование | #{Наименование} |
      | Тип          | #{Тип}          |
      | Экзотический | #{Экзотический} |
    * выполнено нажатие на "Сохранить"
    * страница "Список товаров" загружена
    * ожидается элемент коллекции "Таблица" в течение "10" секунд с параметрами:
      | field        | value           |
      | Наименование | #{Наименование} |
      | Тип          | #{Тип}          |
      | Экзотический | #{Экзотический} |
    * количество элементов коллекции "Таблица" равно "5"

    * сохранить скриншот "Конец теста"
    * debug "Конец теста"