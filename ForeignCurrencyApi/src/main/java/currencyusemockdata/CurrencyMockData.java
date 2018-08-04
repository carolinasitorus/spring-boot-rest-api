package currencyusemockdata;

import javax.persistence.*;

@Entity
public class CurrencyMockData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    public CurrencyMockData() { }

    public CurrencyMockData(int id, String name, String description) {
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CurrencyMockData{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
