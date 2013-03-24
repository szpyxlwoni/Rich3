package org.rich;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

public class BootstrapRichTest {

    private BootstrapRich bootstrapRich;

    @Before
    public void setUp() throws Exception {
        bootstrapRich = new BootstrapRich();
    }

    @Test
    public void should_smoothly_exit_project() {
        System.setIn(new ByteInputStream("12 bomb 4 quit".getBytes(), 14));

        BootstrapRich.main(null);
    }

    @Test
    public void should_success_get_class_given_right_input() {
        bootstrapRich.executeCommandByString("bomb");
    }

    @Test
    public void should_do_nothing_given_input_error_string() {
        bootstrapRich.executeCommandByString("asa");
    }

    @Test
    public void should_create_new_map_players_and_console_input() {
        System.setIn(new ByteInputStream("12".getBytes(), 2));

        bootstrapRich.init();

        assertThat(bootstrapRich.getScanner(), notNullValue());
        assertThat(bootstrapRich.getMap(), notNullValue());
        assertThat(bootstrapRich.getPlayers(), notNullValue());
    }

    @Test
    public void should_create_command_class_name_given_command_string() {
        String commandClassName = bootstrapRich.changeStrToCommandName("bomb");

        assertThat(commandClassName, is("BombCommand"));
    }
}
