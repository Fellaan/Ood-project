package g1.presentation;

import g1.application.ProductApplicationService;
import g1.application.ProductApplicationService.productDTO;

public class ProductOutputFormatter {

    

    // används när man listar alla produkter
    // exempel output:
    // Name: Chair
    public static String displayProduct(String name){
        return String.format("""
                Name: %s
                """, name);
    }

    // används när användaren vill se detaljer om en specifik produkt
    // exempel output:
    // Name: Chair
    // Materials: Wood, Steel
    // Lifespan: 10
    public static String getDetails(productDTO record){
        return String.format("""
                Name: %s
                Category: %s
                Lifespan: %d
                """,
                record.name(),
                record.category(),
                record.lifespan()
                
        );
    }

    // används för recycling guidance
    public static String displayGuidance(String guidance){
        return "Recycling guidance: " + guidance;
    }

    // används för impact resultat
    public static String displayImpact(double impact){
        return "Total climate impact: " + impact;
    }
    
}
