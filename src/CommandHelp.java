public class CommandHelp {

    public void help() {
        System.out.print("""
        === ДОСТУПНЫЕ КОМАНДЫ ===
        help - справка 
        info - инфо о коллекции 
        show - вывести все элементы
        add {element} - добавить 
        update id {element} - обновить 
        remove_by_id id - удалить
        clear - очистить 
        save - сохранить 
        execute_script file_name - запустить скрипт
        exit - выход без сохранения 
        shuffle - перемешать элементы
        add_if_min {element} - добавить, если меньше минимального 
        history - история 11 команд
        count_less_than_weapon_type weaponType - посчитать где weaponType меньше заданного
        filter_by_weapon_type weaponType - фильтр по weaponType 
        print_unique_category - уникальные category
        """);
    }
}
