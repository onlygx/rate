package mybatis;
/**
 * ����mybatis��spring�ļ���
 * ���һ�ȡ���ݿ��е�����
 * Created by GaoXiang on 2015/9/17 0017.
 */

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestMyBatis {

    private static Logger logger = Logger.getLogger(TestMyBatis.class);


    @Test
    public void test1() {

    }
}