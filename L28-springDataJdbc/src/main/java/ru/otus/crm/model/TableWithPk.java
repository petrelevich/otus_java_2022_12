package ru.otus.crm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;

import static org.springframework.data.relational.core.mapping.Embedded.OnEmpty.USE_EMPTY;

@Table("table_with_pk")
public class TableWithPk implements Persistable<TableWithPk.Pk> {

    @Id
    @Embedded(onEmpty = USE_EMPTY)
    private final Pk pk;

    private final String value;

    @Transient
    private final boolean isNew;

    @PersistenceCreator
    public TableWithPk(Pk pk, String value) {
        this(pk, value, false);
    }

    public TableWithPk(Pk pk, String value, boolean isNew) {
        this.pk = pk;
        this.value = value;
        this.isNew = isNew;
    }

    @Override
    public Pk getId() {
        return pk;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    public Pk getPk() {
        return pk;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "TableWithPk{" +
                "pk=" + pk +
                ", value='" + value + '\'' +
                ", isNew=" + isNew +
                '}';
    }

    public static class Pk {
        private final String idPart1;
        private final String idPart2;

        public Pk(String idPart1, String idPart2) {
            this.idPart1 = idPart1;
            this.idPart2 = idPart2;
        }

        public String getIdPart1() {
            return idPart1;
        }

        public String getIdPart2() {
            return idPart2;
        }

        @Override
        public String toString() {
            return "Pk{" +
                    "idPart1='" + idPart1 + '\'' +
                    ", idPart2='" + idPart2 + '\'' +
                    '}';
        }
    }
}
