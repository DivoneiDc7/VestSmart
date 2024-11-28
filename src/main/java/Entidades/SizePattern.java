
package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.dizitart.no2.IndexType;
import org.dizitart.no2.NitriteId;
import org.dizitart.no2.objects.Id;
import org.dizitart.no2.objects.Index;
import org.dizitart.no2.objects.Indices;

@Indices(
    @Index(value = "name", type = IndexType.Unique)
)
public class SizePattern implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    private NitriteId id;
    private String name;
    private List<String> sizes = new ArrayList<>();
    
    public SizePattern() {}

    public SizePattern(String name) {
        this.name = name;
    }

    public NitriteId getId() {
        return id;
    }

    public void setId(NitriteId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSizes() {
        return sizes;
    }

    public void addNewSize(String size) {
        sizes.add(size);
    }
    
    public void removeSize(String size) {
        sizes.remove(size);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SizePattern other = (SizePattern) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SizePattern{" + "id=" + id + ", name=" + name + ", sizes=" + sizes + '}';
    }
    
}