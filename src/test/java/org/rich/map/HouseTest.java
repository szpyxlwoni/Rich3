package org.rich.map;

import org.junit.Test;
import org.rich.player.Player;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class HouseTest {
    @Test
    public void should_return_diff_fee_when_house_in_diff_area() {
        House areaOneHose = new House(1);
        House areaTwoHose = new House(2);
        House areaThreeHose = new House(3);
        House areaFourHose = new House(4);
        House areaFiveHose = new House(5);

        assertThat(areaOneHose.getFee(), is(200));
        assertThat(areaTwoHose.getFee(), is(200));
        assertThat(areaThreeHose.getFee(), is(500));
        assertThat(areaFourHose.getFee(), is(300));
        assertThat(areaFiveHose.getFee(), is(300));
    }
}
