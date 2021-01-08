package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName()
                .thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 2),
                new Job("Impl task", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByPriorityAndName() {
        Comparator<Job> cmpPriorityNameAsc = new JobAscByPriority()
                .thenComparing(new JobAscByName());
        int rsl = cmpPriorityNameAsc.compare(
                new Job("d", 1),
                new Job("b", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByPriorityNameDesc() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 2),
                new Job("Impl task", 2),
                new Job("Reboot server", 2));
        Collections.sort(jobs, new JobDescByPriority()
                .thenComparing(new JobDescByName()));
        assertThat(jobs.toString(), is("[Job{Reboot server, 2},"
                + " Job{Impl task, 2}, Job{Fix bugs, 2}]"));
    }

    @Test
    public void whenComparatorByNameAndPriorityAsc() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 2),
                new Job("Fix bugs", 4),
                new Job("Fix bugs", 6));
        Collections.sort(jobs, new JobAscByName()
                .thenComparing(new JobAscByPriority()));
        assertThat(jobs.toString(), is("[Job{Fix bugs, 2},"
                + " Job{Fix bugs, 4}, Job{Fix bugs, 6}]"));
    }

    @Test
    public void whenComparatorByNameAsc() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1));
        Collections.sort(jobs, new JobAscByName());
        assertThat(jobs.toString(), is("[Job{Fix bugs, 4}, "
                + "Job{Impl task, 2}, Job{Reboot server, 1}]"));
    }

    @Test
    public void whenComparatorByNameDesc() {
        List<Job> jobs = Arrays.asList(new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1));
        Collections.sort(jobs, new JobDescByName());
        assertThat(jobs.toString(), is("[Job{Reboot server, 1},"
                + " Job{Impl task, 2}, Job{Fix bugs, 4}]"));
    }

    @Test
    public void whenComparatorByPriorityAsc() {
        List<Job> jobs = Arrays.asList(new Job("Fix bugs",
                4), new Job("Impl task", 2),
                new Job("Reboot server", 1));
        Collections.sort(jobs, new JobAscByPriority());
        assertThat(jobs.toString(), is("[Job{Reboot server, 1},"
                + " Job{Impl task, 2}, Job{Fix bugs, 4}]"));
    }

    @Test
    public void whenComparatorByPriorityDesc() {
        List<Job> jobs = Arrays.asList(new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1)
        );
        Collections.sort(jobs, new JobDescByPriority());
        assertThat(jobs.toString(), is("[Job{Fix bugs, 4},"
                + " Job{Impl task, 2}, Job{Reboot server, 1}]"));
    }
}
