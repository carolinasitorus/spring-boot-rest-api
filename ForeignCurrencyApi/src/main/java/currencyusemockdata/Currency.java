package currencyusemockdata;

public class Currency {
    private int id;
    private String Name;
    private String description;

    public Currency() { }

    public Currency(int id, String name, String description) {
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
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
