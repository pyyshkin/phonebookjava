import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
  private Map<String, List<String>> contacts;

  public PhoneBook() {
    contacts = new HashMap<>();
  }

  public void addContact(String name, String phone) {
    if(contacts.containsKey(name)){
      List<String> phones = contacts.get(name);
      if(!phones.contains(phone)){
        phones.add(phone);
      }
    } else{
      List<String> phobes = new ArrayList<>();
      phones.add(phone);
      contacts.put(name, phones);
    }
  }

  public void printContacts(boolean sort){
    if(sort){
      sortContacts();
    }
    System.out.println("Contacts:");
    for (Map.Entry<String, List<String>> entry: contacts.entry()){
      String name = entry.getKey();
      List<String> phones = entry.getValue();
      System.out.println(name + " - " + phones.size() + " phones:");
      for (String phone : phones){
        System.out.println("t" + phone);
      }
    }
  }

  private void sortContacts(){
    contacts = new LinkedHashMap<>();
    contacts.entrySet().stream()
      .sorted(Map.Entry.<String, List<String>>comparingByValue(Comparator.comparingInt(ArrayList::size)).reversed())
      .forEachOrdered(x -> contacts.put(x.getKey(), x.getValue()));
  }
}
