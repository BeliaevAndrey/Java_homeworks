## Задание
* Создать наследников класса Компьютер в задаче про ноутбуки
* Создать интерфейс Printable, содержащий описание метода void print(List<Computer>)
* Создать типизированные сервисы на каждый наследник и реализовать в них сервис Printable
* Создать контроллер для отбора по каким либо критериям наследников Компьютера, путем вызова
метода отбора из заранее созданных списков в сервисах и передачи в метод Печать для печати в 
Loger в main продемонстрировать поведение программы



___
## _Решение_
### _Файлы:_

* src/MainOOP04.java  --  класс приложения
* src/computerCls/ -- директория классов
  * Computer.java -- абстрактный класс Computer
  * Memory.java -- перечисление объемов памяти

* src/computerCls/extenders/ -- директория дочерних классов
  + + NoteBook.java  -- класс-наследник Computer
  + + PC.java  -- класс-наследник Computer

* src/exceptionsLocal/  -- директория самодельных исключений
  + StupidUserException.java  -- самодельное исключение

* src/model/  -- общая структурная директория
  * ComputerComparator.java  -- компаратор
  * Controller.java  -- контроллер

  * src/model/interfaces/   -- директория интерфейсов
    + + Printable.java  -- интерфейс печати
    + + Sortable.java  -- интерфейс сортировки

  * src/model/services/  -- директория сервисов
    + + NotebookLoader.java  -- сервис загрузки данных ноутбуков
    + + PCLoader.java  -- сервис загрузки данных перс. компьютеров
    + + NotebookService.java  -- сервис обработки данных ноутбуков
    + + PCService.java  -- сервис обработки данных прес. компьютеров
    + + NotebookFilterService.java  -- сервис фильтра данных ноутбуков
    + + PCFilterService.java  -- сервис фильтра данных прес. компьютеров
