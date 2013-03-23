package org.rich;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

public class BootstrapRichTest {
    @Test
    public void should_smoothly_exit_project() {
        System.setIn(new ByteInputStream("12 quit".getBytes(), 7));

        BootstrapRich.main(null);
    }

    @Test
    public void should_create_new_map_players_and_console_input() {
        System.setIn(new ByteInputStream("12".getBytes(), 2));
        BootstrapRich bootstrapRich = new BootstrapRich();

        bootstrapRich.init();

        assertThat(bootstrapRich.getScanner(), notNullValue());
        assertThat(bootstrapRich.getMap(), notNullValue());
        assertThat(bootstrapRich.getPlayers(), notNullValue());
    }

    @Test
    public void should_create_command_class_name_given_command_string() {
        BootstrapRich bootstrapRich = new BootstrapRich();

        String commandClassName = bootstrapRich.changeStrToCommandName("bomb");

        assertThat(commandClassName, is("BombCommand"));
    }
}
