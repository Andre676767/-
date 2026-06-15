package com.example.demo6;

import java.util.ArrayList;
import java.util.List;

public class FurnitureStore {
    private List<Furniture> catalog;
    private List<CartItem> cart;
    private List<String> categories;

    public FurnitureStore() {
        catalog = new ArrayList<>();
        cart = new ArrayList<>();
        categories = new ArrayList<>();
        initializeCatalog();
    }

    private void initializeCatalog() {
        // Расширенные категории
        categories.addAll(java.util.Arrays.asList(
                "Стулья", "Столы", "Диваны", "Шкафы", "Кровати",
                "Кресла", "Тумбы", "Стеллажи", "Пуфы", "Зеркала",
                "Комоды", "Вешалки", "Барные стойки", "Детская мебель", "Офисная мебель"
        ));

        // ========== СТУЛЬЯ (10 товаров) ==========
        catalog.add(new Furniture("Эргономичный офисный стул", "Стулья", 8990,
                "Ортопедическая спинка, регулировка высоты, подлокотники", 25));
        catalog.add(new Furniture("Кухонный стул деревянный", "Стулья", 3490,
                "Массив бука, мягкое сиденье, прочная конструкция", 40));
        catalog.add(new Furniture("Барный стул высокий", "Стулья", 5990,
                "Металлический каркас, мягкое сиденье, регулировка высоты", 15));
        catalog.add(new Furniture("Игровое кресло", "Стулья", 15990,
                "Кресло для геймеров, поясничная поддержка, наклон спинки 180°", 12));
        catalog.add(new Furniture("Стул с подлокотниками", "Стулья", 4490,
                "Мягкий стул для гостиной, обивка велюр", 30));
        catalog.add(new Furniture("Винтажный стул", "Стулья", 6990,
                "Стуль в стиле лофт, металлические ножки", 18));
        catalog.add(new Furniture("Пластиковый стул", "Стулья", 1990,
                "Легкий складной стул для дачи", 100));
        catalog.add(new Furniture("Стул-трансформер", "Стулья", 12990,
                "Раскладывается в лестницу-стремянку", 8));
        catalog.add(new Furniture("Мягкий банкетный стул", "Стулья", 5490,
                "Для ресторанов и кафе, обивка кожзам", 45));
        catalog.add(new Furniture("Детский стульчик", "Стулья", 2990,
                "Для кормления, со съемным столиком", 22));

        // ========== СТОЛЫ (10 товаров) ==========
        catalog.add(new Furniture("Обеденный стол раздвижной", "Столы", 18990,
                "Дуб, раздвигается до 2.5 м, на 8-10 персон", 10));
        catalog.add(new Furniture("Письменный компьютерный стол", "Столы", 12990,
                "С ящиками и подставкой для системного блока", 15));
        catalog.add(new Furniture("Журнальный столик", "Столы", 6990,
                "Стеклянный, на колесиках", 25));
        catalog.add(new Furniture("Конференц-стол", "Столы", 35990,
                "Для переговоров на 12 человек, с кабель-каналами", 5));
        catalog.add(new Furniture("Туалетный столик", "Столы", 11990,
                "С зеркалом и подсветкой, ящики для косметики", 8));
        catalog.add(new Furniture("Раскладной стол", "Столы", 4990,
                "Для маленькой кухни, раскладывается до 1.4 м", 30));
        catalog.add(new Furniture("Стол-книжка", "Столы", 8490,
                "Классический стол-книжка для гостиной", 20));
        catalog.add(new Furniture("Барный стол", "Столы", 15990,
                "Высокий стол для бара, с полками", 7));
        catalog.add(new Furniture("Стол для пикника", "Столы", 3990,
                "Складной алюминиевый стол для дачи", 50));
        catalog.add(new Furniture("Стол-трансформер", "Столы", 24990,
                "Превращается в шкаф", 4));

        // ========== ДИВАНЫ (10 товаров) ==========
        catalog.add(new Furniture("Угловой диван", "Диваны", 45990,
                "Механизм 'еврокнижка', спальное место 160x200, ткань рогожка", 8));
        catalog.add(new Furniture("Прямой диван", "Диваны", 32990,
                "Тканевая обивка, велюр, два декоративных подушки", 12));
        catalog.add(new Furniture("Раскладной диван-кровать", "Диваны", 39990,
                "Ортопедический матрас, механизм 'аккордеон'", 10));
        catalog.add(new Furniture("Двухместный диван", "Диваны", 24990,
                "Компактный для малогабаритных квартир", 15));
        catalog.add(new Furniture("Диван с подъемным механизмом", "Диваны", 52990,
                "Встроенный ящик для белья", 6));
        catalog.add(new Furniture("Кожаный диван", "Диваны", 79990,
                "Натуральная кожа, классический дизайн", 4));
        catalog.add(new Furniture("Диван-шезлонг", "Диваны", 35990,
                "С откидной ножной секцией", 7));
        catalog.add(new Furniture("Модульный диван", "Диваны", 89990,
                "Трансформируется в 5 разных конфигураций", 3));
        catalog.add(new Furniture("Детский диван", "Диваны", 15990,
                "Яркий диванчик для детской комнаты", 20));
        catalog.add(new Furniture("Диван на балкон", "Диваны", 12990,
                "Узкий диван для балкона или прихожей", 18));

        // ========== ШКАФЫ (8 товаров) ==========
        catalog.add(new Furniture("Книжный шкаф", "Шкафы", 18990,
                "Высокий, 5 полок, из ЛДСП", 12));
        catalog.add(new Furniture("Шкаф-купе", "Шкафы", 38990,
                "Зеркальные двери, внутреннее наполнение", 6));
        catalog.add(new Furniture("Угловой шкаф", "Шкафы", 29990,
                "Вместительный, система хранения", 5));
        catalog.add(new Furniture("Шкаф для одежды", "Шкафы", 24990,
                "Двухстворчатый, штанга и полки", 10));
        catalog.add(new Furniture("Встроенный шкаф", "Шкафы", 45990,
                "Изготовление на заказ по вашим размерам", 3));
        catalog.add(new Furniture("Шкаф-витрина", "Шкафы", 21990,
                "Со стеклянными дверцами для посуды", 7));
        catalog.add(new Furniture("Платяной шкаф", "Шкафы", 27990,
                "Трехстворчатый, большая вместительность", 8));
        catalog.add(new Furniture("Компактный шкаф", "Шкафы", 14990,
                "Для прихожей, с вешалкой и обувницей", 15));

        // ========== КРОВАТИ (8 товаров) ==========
        catalog.add(new Furniture("Двуспальная кровать", "Кровати", 28990,
                "Ортопедическое основание, подъемный механизм", 10));
        catalog.add(new Furniture("Односпальная кровать", "Кровати", 16990,
                "Компактная, с ящиками для белья", 15));
        catalog.add(new Furniture("Кровать-чердак", "Кровати", 42990,
                "Для детей, спальное место сверху, стол снизу", 5));
        catalog.add(new Furniture("Кровать с матрасом", "Кровати", 35990,
                "Комплект: кровать + ортопедический матрас", 8));
        catalog.add(new Furniture("Кровать-пантограф", "Кровати", 49990,
                "С подъемным механизмом и мягким изголовьем", 4));
        catalog.add(new Furniture("Детская кровать", "Кровати", 12990,
                "Для ребенка от 3 лет, защитные бортики", 20));
        catalog.add(new Furniture("Кровать-машина", "Кровати", 25990,
                "Для мальчиков в форме автомобиля", 6));
        catalog.add(new Furniture("Раскладушка", "Кровати", 5990,
                "Складная кровать для гостей", 30));

        // ========== КРЕСЛА (6 товаров) ==========
        catalog.add(new Furniture("Кресло-качалка", "Кресла", 10990,
                "Деревянное, плавное качание", 12));
        catalog.add(new Furniture("Кресло-мешок", "Кресла", 5990,
                "Бескаркасное, наполнитель из пенополистирола", 25));
        catalog.add(new Furniture("Компьютерное кресло", "Кресла", 13990,
                "Эргономичное, сетчатая спинка", 18));
        catalog.add(new Furniture("Массажное кресло", "Кресла", 89990,
                "Электрическое, 6 программ массажа", 3));
        catalog.add(new Furniture("Кресло-трансформер", "Кресла", 18990,
                "Раскладывается в односпальную кровать", 7));
        catalog.add(new Furniture("Подвесное кресло", "Кресла", 14990,
                "Плетеное, для веранды или дома", 5));

        // ========== ТУМБЫ (4 товара) ==========
        catalog.add(new Furniture("Тумба под телевизор", "Тумбы", 9990,
                "С двумя ящиками, для ТВ до 65 дюймов", 15));
        catalog.add(new Furniture("Прикроватная тумба", "Тумбы", 4490,
                "С выдвижным ящиком и полкой", 30));
        catalog.add(new Furniture("Тумба для обуви", "Тумбы", 3990,
                "Узкая, с откидной крышкой", 25));
        catalog.add(new Furniture("Тумба для ванной", "Тумбы", 6990,
                "Влагостойкая, с раковиной", 10));

        // ========== СТЕЛЛАЖИ (4 товара) ==========
        catalog.add(new Furniture("Стеллаж для книг", "Стеллажи", 7990,
                "Открытый, 4 полки", 20));
        catalog.add(new Furniture("Стеллаж для гостиной", "Стеллажи", 12990,
                "С ящиками внизу, для хранения", 12));
        catalog.add(new Furniture("Промышленный стеллаж", "Стеллажи", 15990,
                "В стиле лофт, металлический", 8));
        catalog.add(new Furniture("Угловой стеллаж", "Стеллажи", 9990,
                "Экономит место, 5 полок", 10));

        // ========== ПУФЫ (3 товара) ==========
        catalog.add(new Furniture("Мягкий пуф", "Пуфы", 2990,
                "Круглый, с наполнителем", 35));
        catalog.add(new Furniture("Пуф с крышкой", "Пуфы", 3990,
                "Внутри место для хранения", 28));
        catalog.add(new Furniture("Кожаный пуф", "Пуфы", 5990,
                "Экокожа, квадратный", 15));

        // ========== ЗЕРКАЛА (3 товара) ==========
        catalog.add(new Furniture("Напольное зеркало", "Зеркала", 4990,
                "В полный рост, на подставке", 12));
        catalog.add(new Furniture("Настенное зеркало", "Зеркала", 2990,
                "Овальное, в деревянной раме", 20));
        catalog.add(new Furniture("Зеркало с подсветкой", "Зеркала", 8990,
                "Светодиодная подсветка, для гримерной", 8));

        // ========== КОМОДЫ (3 товара) ==========
        catalog.add(new Furniture("Комод для белья", "Комоды", 12990,
                "4 выдвижных ящика, из ЛДСП", 12));
        catalog.add(new Furniture("Комод в прихожую", "Комоды", 8990,
                "Узкий, с открытыми полками", 15));
        catalog.add(new Furniture("Комод для детской", "Комоды", 10990,
                "С рисунком, безопасные углы", 10));

        // ========== ВЕШАЛКИ (3 товара) ==========
        catalog.add(new Furniture("Напольная вешалка", "Вешалки", 2990,
                "Металлическая, на колесиках", 30));
        catalog.add(new Furniture("Настенная вешалка", "Вешалки", 1990,
                "С крючками, для прихожей", 45));
        catalog.add(new Furniture("Стойка для одежды", "Вешалки", 3990,
                "Напольная, для магазина или дома", 18));

        // ========== БАРНЫЕ СТОЙКИ (2 товара) ==========
        catalog.add(new Furniture("Домашняя барная стойка", "Барные стойки", 18990,
                "С полками для бутылок и бокалов", 5));
        catalog.add(new Furniture("Барная стойка-остров", "Барные стойки", 29990,
                "Для кухни-гостиной, с раковиной", 3));

        // ========== ДЕТСКАЯ МЕБЕЛЬ (4 товара) ==========
        catalog.add(new Furniture("Детский письменный стол", "Детская мебель", 8990,
                "С регулировкой высоты и наклоном столешницы", 15));
        catalog.add(new Furniture("Детский стул", "Детская мебель", 2990,
                "Растущий стул, регулировка по росту", 25));
        catalog.add(new Furniture("Комплект для детской", "Детская мебель", 29990,
                "Стол, стул, шкаф и кровать", 5));
        catalog.add(new Furniture("Игровой домик", "Детская мебель", 15990,
                "Детский домик-палатка", 8));

        // ========== ОФИСНАЯ МЕБЕЛЬ (4 товара) ==========
        catalog.add(new Furniture("Офисное кресло", "Офисная мебель", 11990,
                "Сетчатая спинка, регулировки", 20));
        catalog.add(new Furniture("Стол для переговоров", "Офисная мебель", 25990,
                "Овальный, на 8 человек", 6));
        catalog.add(new Furniture("Офисный стеллаж", "Офисная мебель", 6990,
                "Для папок и документов", 15));
        catalog.add(new Furniture("Ресепшн стойка", "Офисная мебель", 39990,
                "Для зоны приема посетителей", 4));
    }

    public List<Furniture> getFurnitureByCategory(String category) {
        List<Furniture> result = new ArrayList<>();
        for (Furniture f : catalog) {
            if (f.getCategory().equals(category)) {
                result.add(f);
            }
        }
        return result;
    }

    public List<String> getCategories() {
        return new ArrayList<>(categories);
    }

    public List<Furniture> getAllFurniture() {
        return new ArrayList<>(catalog);
    }

    public void addToCart(Furniture furniture, int quantity) {
        for (CartItem item : cart) {
            if (item.getFurniture().equals(furniture)) {
                int newQuantity = item.getQuantity() + quantity;
                if (newQuantity <= furniture.getStock()) {
                    item.setQuantity(newQuantity);
                } else {
                    item.setQuantity(furniture.getStock());
                }
                return;
            }
        }
        int finalQuantity = Math.min(quantity, furniture.getStock());
        if (finalQuantity > 0) {
            cart.add(new CartItem(furniture, finalQuantity));
        }
    }

    public void removeFromCart(Furniture furniture) {
        cart.removeIf(item -> item.getFurniture().equals(furniture));
    }

    public List<CartItem> getCart() {
        return new ArrayList<>(cart);
    }

    public double getCartTotal() {
        return cart.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    public void clearCart() {
        cart.clear();
    }

    public int getTotalItemsCount() {
        return catalog.size();
    }

    public String getCatalogStats() {
        return String.format("Всего товаров: %d, категорий: %d", catalog.size(), categories.size());
    }
}