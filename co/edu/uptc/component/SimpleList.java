package co.edu.uptc.component;


public class SimpleList<T> {
    private Node<T> head;
    private int size=0;

    public SimpleList<Car> sortCars(SimpleList<Car> simpleListCar){
        SimpleList<Car> sortCars = new SimpleList<>();
        for (int i = 1; i <= simpleListCar.getSize(); i++) {
            Node<Car> nuevo = new Node<Car>(simpleListCar.getNodePos(i).getInformation(),simpleListCar.getNodePos(i).getNext());
            Node<Car> reco1;
            Node<Car> reco2;
            if(sortCars.head == null){
                sortCars.head = nuevo;
                nuevo.setNext(null);
            }else {
                reco1 = sortCars.head;
                
                while (reco1 != null){
                    reco2 = reco1.getNext();
                    if(nuevo.getInformation().getModel()>=reco1.getInformation().getModel()){
                        nuevo.setNext(sortCars.head);
                        sortCars.head = nuevo;
                        break;
                    }else {
                        if(nuevo.getInformation().getModel()<reco1.getInformation().getModel() && reco2 == null){
                            reco1.setNext(nuevo);
                            nuevo.setNext(null);
                            break;
                        }else {
                            if(reco1.getInformation().getModel()>nuevo.getInformation().getModel() && reco2.getInformation().getModel()<=nuevo.getInformation().getModel()){
                                reco1.setNext(nuevo);
                                nuevo.setNext(reco2);
                                break;
                            }else {
                                reco1 = reco1.getNext();
                            }
                        }
                    }
                }
            }
            sortCars.size++;
        }
        return sortCars;
    }
    public SimpleList<Person> sortPerson(SimpleList<Person> personList){
        SimpleList<Person> sortPeople = new SimpleList<>();
        for (int i = 1; i <= personList.getSize(); i++) {
            Node<Person> nuevo = new Node<Person>(personList.getNodePos(i).getInformation(),personList.getNodePos(i).getNext());
            Node<Person> reco1;
            Node<Person> reco2;
            if(sortPeople.head == null){
                sortPeople.head = nuevo;
                nuevo.setNext(null);
            }else {
                reco1 = sortPeople.head;
                
                while (reco1 != null){
                    reco2 = reco1.getNext();
                    if(nuevo.getInformation().getName().compareTo(reco1.getInformation().getName())<0){
                        nuevo.setNext(sortPeople.head);
                        sortPeople.head = nuevo;
                        break;
                    }else {
                        if(nuevo.getInformation().getName().compareTo(reco1.getInformation().getName())>0 && reco2 == null){
                            reco1.setNext(nuevo);
                            nuevo.setNext(null);
                            break;
                        }else {
                            if(reco1.getInformation().getName().compareTo(nuevo.getInformation().getName())<0 && reco2.getInformation().getName().compareTo(nuevo.getInformation().getName())==0){
                                reco1.setNext(nuevo);
                                nuevo.setNext(reco2);
                                break;
                            }else {
                                reco1 = reco1.getNext();
                            }
                        }
                    }
                }
            }
            sortPeople.size++;
        }
        return sortPeople;
    }
    public void add(T t){
        Node<T> aux = new Node<T>(t,null);
        if (head==null){
            head = aux;
        } else {
            Node<T> last = getLast();
            last.setNext(aux);
        }this.size++;
    }

    public void add(T info,int pos){
        Node<T> aux = new Node<T>(info,null);
        if (pos==0){
            aux.setNext(head);
            head = aux;
        } else {
            Node<T> posNode = getNodePos(pos);
            aux.setNext(posNode.getNext());
            posNode.setNext(aux);
        }
    }

    public Node<T> getNodePos(int pos){
        Node<T> posNode = head;
        int cont=0;
        while (posNode.getNext()!=null&&cont<pos-1) {
            posNode = posNode.getNext();
            cont = cont+1;
        }
        return posNode;
    }

    private Node<T> getLast(){
        Node<T> last = head;
        while (last.getNext()!=null)
            last = last.getNext();
        return last;
    }

    public void showAll(){
        Node<T> last = head;
        do  {
            last = last.getNext();
        } while (last!=null);
    }

    public void add(SimpleList<T> simpleList,int pos){
        if (pos==0){
            Node<T> last= simpleList.getLast();
            last.setNext(head);
            head = simpleList.head;
        }

    }
    public int getSize() {
        return size;
    }
    public int setSize(int size) {
        return this.size=size;
    }

}
