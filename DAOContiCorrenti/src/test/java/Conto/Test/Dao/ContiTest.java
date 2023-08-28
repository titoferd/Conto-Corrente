package Conto.Test.Dao;

import Conto.Dao.DaoConti;
import Conto.Dao.DaoException;
import Conto.Dao.IDao;
import Conto.Dto.Conti;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.function.Executable;

import java.util.List;

public class ContiTest extends DaoAbstractTest <Conti, Long> {

    @Override
    IDao<Conti, Long> getDao() {
        return new DaoConti();
    }

//    @Override
//    protected Executable getAssertionsTestRead(Conti c) {
//        return () -> {
//            Assertions.assertAll(
//                    "errore",
//                    () -> Assertions.assertEquals("I", c.getCIN()),
//                    () -> Assertions.assertEquals(11111, c.getABI()),
//                    () -> Assertions.assertEquals(22222, c.getCAB()),
//                    () -> Assertions.assertEquals(100000000002L, c.getNumeroConto()),
//                    () -> Assertions.assertEquals("EE", c.getNomeTitolare()),
//                    ()-> Assertions.assertEquals("BB", c.getCognomeTitolare()),
//                    ()-> Assertions.assertEquals("BB24H2H4J3J1J2J2", c.getCodiceFiscaleTitolare())
//            );
//        };
//    }

    @Override
    Conti getItemTestInsert() {
        return new Conti("T", 99999, 77777, "AB", "AB", "BB24H2H4J3J1J2J2");
    }

    @Override
    Executable getAssertionsTestInsert() {
        return () -> Assertions.assertTrue(getDao().findByText("BB24H2H4J3J1J2J2").equals("BB24H2H4J3J1J2J2"));
    }

}
