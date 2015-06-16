package personalFinance.util;

import java.util.ArrayList;
import java.util.List;

import personalFinance.domain.Category;


public class CategoryUtil {

    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";

    private CategoryUtil() {
    }

    public static Category createCategory() {
        return new Category(NAME, DESCRIPTION);
    }

    public static List<Category> createCategoryList(int howMany) {
        List<Category> categoryList = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
        	categoryList.add(new Category(NAME + "TESTE" + i, DESCRIPTION + "TESTE" + i));
        }
        return categoryList;
    }

}
