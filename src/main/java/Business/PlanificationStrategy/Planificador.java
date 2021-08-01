package Business.PlanificationStrategy;

import Business.Cadena;
import Business.Cine;
import Business.Pelicula;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Planificador {

    List<Pelicula> todasLasPelis = new List<Pelicula>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Pelicula> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Pelicula pelicula) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Pelicula> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Pelicula> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Pelicula get(int index) {
            return null;
        }

        @Override
        public Pelicula set(int index, Pelicula element) {
            return null;
        }

        @Override
        public void add(int index, Pelicula element) {

        }

        @Override
        public Pelicula remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Pelicula> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Pelicula> listIterator(int index) {
            return null;
        }

        @Override
        public List<Pelicula> subList(int fromIndex, int toIndex) {
            return null;
        }
    };

    List<Pelicula> pelisPrioridadAlta  = new List<Pelicula>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Pelicula> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Pelicula pelicula) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Pelicula> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Pelicula> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Pelicula get(int index) {
            return null;
        }

        @Override
        public Pelicula set(int index, Pelicula element) {
            return null;
        }

        @Override
        public void add(int index, Pelicula element) {

        }

        @Override
        public Pelicula remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Pelicula> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Pelicula> listIterator(int index) {
            return null;
        }

        @Override
        public List<Pelicula> subList(int fromIndex, int toIndex) {
            return null;
        }
    };
    List<Pelicula> pelisPrioridadMedia = new List<Pelicula>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Pelicula> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Pelicula pelicula) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Pelicula> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Pelicula> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Pelicula get(int index) {
            return null;
        }

        @Override
        public Pelicula set(int index, Pelicula element) {
            return null;
        }

        @Override
        public void add(int index, Pelicula element) {

        }

        @Override
        public Pelicula remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Pelicula> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Pelicula> listIterator(int index) {
            return null;
        }

        @Override
        public List<Pelicula> subList(int fromIndex, int toIndex) {
            return null;
        }
    };
    List<Pelicula> pelisPrioridadBaja  = new List<Pelicula>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Pelicula> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Pelicula pelicula) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Pelicula> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Pelicula> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Pelicula get(int index) {
            return null;
        }

        @Override
        public Pelicula set(int index, Pelicula element) {
            return null;
        }

        @Override
        public void add(int index, Pelicula element) {

        }

        @Override
        public Pelicula remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Pelicula> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Pelicula> listIterator(int index) {
            return null;
        }

        @Override
        public List<Pelicula> subList(int fromIndex, int toIndex) {
            return null;
        }
    };

    List<Cine> listaDeCines = new List<Cine>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Cine> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Cine cine) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Cine> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Cine> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Cine get(int index) {
            return null;
        }

        @Override
        public Cine set(int index, Cine element) {
            return null;
        }

        @Override
        public void add(int index, Cine element) {

        }

        @Override
        public Cine remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Cine> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Cine> listIterator(int index) {
            return null;
        }

        @Override
        public List<Cine> subList(int fromIndex, int toIndex) {
            return null;
        }
    };

    PlanificationStrategy estrategiaActual;

    public void elegirPlanificacion(int estrategiaDePlanificacion){
        if(estrategiaDePlanificacion == 1){
            estrategiaActual =  new EstrategiaEstandar();
        }else{
            estrategiaActual =  new EstrategiaInfantil();
        }
    }

    public void planificar(){

        Cadena cadena = Cadena.getInstance();
        todasLasPelis = cadena.getPeliculas();

        estrategiaActual.darPrioridadAPeliculas(todasLasPelis, pelisPrioridadAlta, pelisPrioridadMedia, pelisPrioridadBaja);

        listaDeCines = cadena.getCines();

        for(Cine cine : listaDeCines){
            cine.recibirPeliculas(pelisPrioridadAlta, pelisPrioridadMedia, pelisPrioridadBaja);
        }

    }

}
