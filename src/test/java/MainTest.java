import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

public class MainTest {




    @Test
    public void negValidIPLength()  {
        String[] mass = {"192", "168", "1", "1", "1"};
        Assert.assertTrue(!Main.validIP(mass));

    }
    @Test
    public void negValidIPChar()  {
        String[] mass = {"192", "168", "1", "d"};
        Assert.assertTrue(!Main.validIP(mass));

    }
    @Test
    public void negValidIPFirstOkt()  {
        String[] mass = {"190", "168", "1", "1"};
        Assert.assertTrue(!Main.validIP(mass));

    }
    @Test
    public void negValidIPSecOkt()  {
        String[] mass = {"192", "200", "1", "1"};
        Assert.assertTrue(!Main.validIP(mass));

    }
//незнаю почему но данный тест не проходит при запуске группы тестов но прекрасно срабатывает отдельно.
    @Test
    public void inputIP() {
        ByteArrayInputStream in = new ByteArrayInputStream("192.168.1.1".getBytes());
        System.setIn(in);
        String[] mass = {"192", "168", "1", "1" };

        Assert.assertArrayEquals(mass,  Main.inputIP());

        System.setIn(System.in);
    }
}