package products.dto.bindings;

import com.google.gson.annotations.Expose;

/**
 * Created by Hristo Skipernov on 01/08/2017.
 */

public class CategoryImportDto {

    @Expose
    private String name;

    public CategoryImportDto() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
