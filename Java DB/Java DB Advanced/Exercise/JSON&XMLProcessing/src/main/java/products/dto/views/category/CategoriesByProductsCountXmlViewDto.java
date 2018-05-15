package products.dto.views.category;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Hristo Skipernov on 01/08/2017.
 */

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriesByProductsCountXmlViewDto {

    @XmlElement(name = "category")
    private List<CategoryByProductsCountViewDto> categoryByProductsCountViewDtos;

    public CategoriesByProductsCountXmlViewDto() {
    }

    public List<CategoryByProductsCountViewDto> getCategoryByProductsCountViewDtos() {
        return this.categoryByProductsCountViewDtos;
    }

    public void setCategoryByProductsCountViewDtos(List<CategoryByProductsCountViewDto> categoryByProductsCountViewDtos) {
        this.categoryByProductsCountViewDtos = categoryByProductsCountViewDtos;
    }
}
