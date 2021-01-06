package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(bugWithDesc, is(bugWithDesc));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenSortAscItem() {
        Tracker tracker = new Tracker();
        List<Item> expectedList = new ArrayList<>();
        Item item1 = new Item();
        item1.setName("fix Bugs");
        tracker.add(item1);
        Item item2 = new Item();
        item2.setName("clean laptop");
        tracker.add(item2);
        Item item3 = new Item();
        item3.setName("go train");
        tracker.add(item3);
        expectedList.add(item3);
        expectedList.add(item1);
        expectedList.add(item2);
        Collections.sort(expectedList, new SortItemByAsc());
        assertThat(expectedList.toString(), is("[Item{id=1, name='fix Bugs'}, " +
                "Item{id=2, name='clean laptop'}, Item{id=3, name='go train'}]"));
    }

    @Test
    public void whenSortDescItemByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item();
        item1.setName("a");
        tracker.add(item1);
        Item item2 = new Item();
        item2.setName("b");
        tracker.add(item2);
        Item item3 = new Item();
        item3.setName("c");
        tracker.add(item3);
        List<Item> expectedList = tracker.findAll();
        Collections.sort(expectedList, new SortItemByDesc());
        assertThat(expectedList.toString(), is("[Item{id=3, name='c'}," +
                " Item{id=2, name='b'}, Item{id=1, name='a'}]"));
    }
}