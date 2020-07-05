# Zoo

## Задача

Разработать программу,модулирующую поведение животных в зоопарке.

Полное описание [здесь](Zoo_Task.jpg).


## Описание проекта

В проекте использовался _паттерн Наблюдатель_.

В роли **наблюдаемого объекта** выступает интерфейс _Observable_, который определяет методы:
 - **_addAnimal_** - для добавления наблюдателя в список наблюдающих
 
 - **_removeAnimal_** - для удаления наблюдателя из списка наблюдающих
 
 - **_notifyAnimals_** - для уведомления всех подписавшихся наблюдателей
 
 Класс Zoo реализует наблюдаемый объект.

 ---
 
В роли **наблюдателя** выступает интерфейс _Observer_,который подписывается 
на все уведомления наблюдаемого объекта
и предоставляет метод **_update_** для получения уведомлений.

Класс Animal реализует наблюдателя.

 ---

С помощью данных методов пользователь имитирует события в зоопарке:
 - **setNight**
 - **visit**
 - **feed**
 - **setThunder**
 - **setMorning**

В ответ на эти события наблюдаемый объект оповещает всех текущих наблюдателей о произошедшем событии.

      