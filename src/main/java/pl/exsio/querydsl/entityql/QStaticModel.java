package pl.exsio.querydsl.entityql;

import com.querydsl.core.dml.StoreClause;
import com.querydsl.core.types.Path;
import pl.exsio.querydsl.entityql.ex.InvalidArgumentException;

/**
 * Parent Class of all Static Models generated by EntityQL. Contains some convenience methods.
 *
 * @param <E> - source Entity Type
 */
public class QStaticModel<E> extends QBase<E> {

    public QStaticModel(Class<? extends E> type, String variable, String schema, String table) {
        super(type, variable, schema, table);
    }

    /**
     * Convenience method used to quiclky set values on insert/update/merge clauses.
     * Method requires the 'params' parameter to be of even size.
     * Every other params array item has to be a Path
     *
     * Example:
     *
     * QBook book = QBook.INSTANCE;
     * book.set(
     *      queryFactory.insert(book),
     *      book.id, 11L,
     *      book.name, "newBook2",
     *      book.price, BigDecimal.ONE
     * ).execute();
     *
     * @param clause - insert/update/merge clause
     * @param params - varargs array with parameters
     * @return clause from the 1st argument
     */
    @SuppressWarnings(value = "unchecked")
    public <C extends StoreClause<C>> StoreClause<C> set(StoreClause<C> clause, Object... params) {
        if (params.length % 2 != 0) {
            throw new InvalidArgumentException("Odd number of parameters");
        }
        for (int i = 0; i < params.length - 1; i += 2) {
            Object key = params[i];
            Object value = params[i + 1];
            if (!(key instanceof Path)) {
                throw new InvalidArgumentException("Param key has to be Path");
            }
            clause.set((Path<Object>) key, value);
        }
        return clause;
    }

    /**
     * Convenience method to obtain a corresponding Dynamic Query Model
     *
     * @return Dynamic Q-Model for corresponding Static Model
     */
    @SuppressWarnings(value = "unchecked")
    public Q<E> dynamic() {
        Class<E> type = (Class<E>) getType();
        return EntityQL.qEntity(type);
    }

    /**
     * Convenience method to obtain a corresponding Dynamic Query Model
     *
     * Variables are serving as Table Aliases in generated SQL Statements
     * Default variable is always equal to the table name itself.
     * Custom variable is handy if we want to use the same Table multiple
     * times in the same SQL query.
     *
     * @param variable - custom variable name
     * @return Dynamic Q-Model for corresponding Static Model
     */
    @SuppressWarnings(value = "unchecked")
    public Q<E> dynamic(String variable) {
        Class<E> type = (Class<E>) getType();
        return EntityQL.qEntity(type, variable);
    }
}
