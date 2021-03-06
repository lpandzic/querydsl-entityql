package pl.exsio.querydsl.entityql.config.entity.generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.sql.PrimaryKey;
import pl.exsio.querydsl.entityql.QColumnMetadataFactory;
import pl.exsio.querydsl.entityql.QPathConfig;
import pl.exsio.querydsl.entityql.QPathFactory;
import pl.exsio.querydsl.entityql.QStaticModel;

import java.util.ArrayList;
import java.util.List;

/**
 * This class was generated by EntityQL (https://github.com/eXsio/querydsl-entityql). It is not
 * recommended to make any changes to this class. Any manual changes will be lost upon the next
 * class generation.
 */
public final class QJCompositePk
    extends QStaticModel<pl.exsio.querydsl.entityql.config.entity.JCompositePk> {

  public static final QJCompositePk INSTANCE = new QJCompositePk();

  public final NumberPath<java.lang.Long> id1;

  public final StringPath id2;

  public final StringPath desc;

  public final PrimaryKey<pl.exsio.querydsl.entityql.config.entity.JCompositePk> _primaryKey;

  public QJCompositePk() {
    this("JCOMPOSITE_PK");
  }

  @SuppressWarnings(value = "unchecked")
  public QJCompositePk(String variable) {
    super(
        pl.exsio.querydsl.entityql.config.entity.JCompositePk.class, variable, "", "JCOMPOSITE_PK");

    id1:
    {
      QPathConfig config =
          new QPathConfig(java.lang.Long.class, java.lang.Long.class, "ID_1", true, 1, -5);

      this.id1 = QPathFactory.<NumberPath<java.lang.Long>>create(this, config);

      addMetadata(this.id1, QColumnMetadataFactory.create(config));
    }

    id2:
    {
      QPathConfig config =
          new QPathConfig(java.lang.String.class, java.lang.String.class, "ID_2", true, 2, 12);

      this.id2 = QPathFactory.<StringPath>create(this, config);

      addMetadata(this.id2, QColumnMetadataFactory.create(config));
    }

    desc:
    {
      QPathConfig config =
          new QPathConfig(java.lang.String.class, java.lang.String.class, "DESC", true, 3, 12);

      this.desc = QPathFactory.<StringPath>create(this, config);

      addMetadata(this.desc, QColumnMetadataFactory.create(config));
    }

    _primaryKey:
    {
      List<Path> paths = new ArrayList();

      paths.add(this.id1);

      paths.add(this.id2);

      this._primaryKey =
          this.<pl.exsio.querydsl.entityql.config.entity.JCompositePk>createPrimaryKey(
              paths.<Path>toArray(new Path[0]));
    }
  }
}
