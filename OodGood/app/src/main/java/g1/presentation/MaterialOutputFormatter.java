package g1.presentation;
import g1.application.MaterialDto;

public class MaterialOutputFormatter {

    
    public static String materialDto(MaterialDto record){
    return String.format("""
                Name: %s
                Category: %s
                Emission Factor: %.2f
                """,
                record.name(),
                record.recyclingCategory(),
                record.emissionFactor()
                
        );

    }
    public static String displayMaterial(MaterialDto record){
    return String.format("""
            Name: %s
            """,
        record.name());
    
    }




}
