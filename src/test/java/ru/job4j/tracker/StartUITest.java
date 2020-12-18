package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

    public class StartUITest {

        @Test
        public void whenExit() {
            Output out = new StubOutput();
            Input in = new StubInput(
                    new String[] {"0"}
            );
            Tracker tracker = new Tracker();
            UserAction[] actions = {
                    new ExitAction(out)
            };
            new StartUI(out).init(in, tracker, actions);
            assertThat(out.toString(), is(
                    "Menu." + System.lineSeparator() +
                            "0. Exit" + System.lineSeparator()
            ));
        }

        @Test
        public void whenCreateItem() {
            Output out = new StubOutput();
            Input in = new StubInput(
                    new String[] {"0", "Item name", "1"}
            );
            Tracker tracker = new Tracker();
            UserAction[] actions = {
                    new CreateAction(out),
                    new ExitAction(out)
            };
            new StartUI(out).init(in, tracker, actions);
            assertThat(tracker.findAll()[0].getName(), is("Item name"));
        }

        @Test
        public void whenReplaceItem() {
            Output out = new StubOutput();
            Tracker tracker = new Tracker();
            /* Добавим в tracker новую заявку */
            Item item = tracker.add(new Item("Replaced item"));
            /* Входные данные должны содержать ID добавленной заявки item.getId() */
            String replacedName = "New item name";
            Input in = new StubInput(
                    new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
            );
            UserAction[] actions = {
                    new ReplaceAction(out),
                    new ExitAction(out)
            };
            new StartUI(out).init(in, tracker, actions);
            assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
        }

        @Test
        public void whenDeleteItem() {
            Output out = new StubOutput();
            Tracker tracker = new Tracker();
            /* Добавим в tracker новую заявку */
            Item item = tracker.add(new Item("Deleted item"));
            /* Входные данные должны содержать ID добавленной заявки item.getId() */
            Input in = new StubInput(
                    new String[] {"0", String.valueOf(item.getId()), "1"}
                    );
            UserAction[] actions = {
                    new DeleteAction(out),
                    new ExitAction(out)
            };
            new StartUI(out).init(in, tracker, actions);
            assertThat(tracker.findById(item.getId()), is(nullValue()));
        }
        @Test
        public void whenFindItem() {
            Output out = new StubOutput();
            Input in = new StubInput(
                    new String[] {"0", "Item name", "2"}
            );
            Tracker tracker = new Tracker();
            UserAction[] actions = {
                    new CreateAction(out),
                    new ReadeItemAction(out),
                    new ExitAction(out)
            };
            new StartUI(out).init(in, tracker, actions);
            assertThat(out.toString(), is("Menu.\n0. Create\n" +
                    "1. find by id.\n2. Exit\n=== Create a new Item ====\n" +
                    "Menu.\n0. Create\n1. find by id.\n2. Exit\n"));
        }

        @Test
        public void whenFindItems() {
            Output out = new StubOutput();
            Input in = new StubInput(
                    new String[] {"0", "Item name1", "2"}
            );
            Tracker tracker = new Tracker();
            UserAction[] actions = {
                    new CreateAction(out),
                    new ReadeItemsAction(out),
                    new ExitAction(out)
            };
            new StartUI(out).init(in, tracker, actions);
            assertThat(out.toString(), is("Menu.\n0. Create\n" +
                    "1. find all Items\n2. Exit\n=== Create a new Item ====\n" +
                    "Menu.\n0. Create\n1. find all Items\n2. Exit\n"));
        }

        @Test
        public void whenFindByName() {
            Output out = new StubOutput();
            Input in = new StubInput(
                    new String[] {"0", "Item name", "2"}
            );
            Tracker tracker = new Tracker();
            UserAction[] actions = {
                    new CreateAction(out),
                    new FindAction(out),
                    new ExitAction(out)
            };
            new StartUI(out).init(in, tracker, actions);
            assertThat(out.toString(), is("Menu.\n0. Create\n" +
                    "1. find by name\n2. Exit\n=== Create a new Item ====\n" +
                    "Menu.\n0. Create\n1. find by name\n2. Exit\n"));
        }

        @Test
        public void whenInvalidExit() {
            Output out = new StubOutput();
            Input in = new StubInput(
                    new String[] {"1", "0"}
            );
            Tracker tracker = new Tracker();
            UserAction[] actions = {
                    new ExitAction(out)
            };
            new StartUI(out).init(in, tracker, actions);
            assertThat(out.toString(), is(
                    String.format(
                            "Menu.%n"
                                    + "0. Exit%n"
                                    + "Wrong input, you can select: 0 .. 0%n"
                                    + "Menu.%n"
                                    + "0. Exit%n"
                    )
            ));
        }
    }