package com.lambda.impex.ast;

public interface TypeFinder {

    TypeDescription findType(String typeName);

    /**
     * Find type by its simple name obtained from an impex header, <br>
     * for example for the type names (bold) from the following impex header snippet:<br>
     * <code>UPDATE <b>Media</b>; catalogVersion(<b>CatalogVersion</b>.catalog(<b>Catalog</b>.id[default=$contentCatalog]), (...) </code><br>
     * this method will return respectively: <b>MediaModel</b>, <b>CatalogVersionModel</b>, <b>CatalogModel</b>
     *
     * @param name
     * @return
     */
    TypeDescription findBySimpleName(String name);
}
