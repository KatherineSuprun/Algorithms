import java.util.*;
public class EulerPath {
    Map<String, List<String>> graph = new HashMap<>(); // граф в виде списка смежности
    Set<String> nodes = new HashSet<>(); // отдельный список нодов, для удобства

    List<String> result = new ArrayList<>(); // массив для результатов
    List<String> path = new ArrayList<>(); // массив для хранения эйлерова пути (цикла)
    Stack<String> vertexStack = new Stack<>(); // стек нодов
    Stack<String> edgeStack = new Stack<>(); // стек ребер (самих слов)

    /*
    Два вспомогательных метода, для лучшей читаемости кода
     */
    String firstLetterOf(String word) {
        return word.substring(0, 1).toLowerCase();
    }

    String lastLetterOf(String word) {
        return word.substring(word.length() - 1).toLowerCase();
    }

    /*
    Инициализация графа и списка нодов
    с помощью конструктора

     */
    EulerPath(String[] inputSequence) {
        for (String word : inputSequence) {
            nodes.add(firstLetterOf(word));
            nodes.add(lastLetterOf(word));
        }
        for (String node : nodes) {
            graph.put(node, new ArrayList<>());
        }
        for (String word : inputSequence) {
            String node = firstLetterOf(word);
            List<String> tmp = graph.get(node);
            tmp.add(word);
        }
    }

    String getStartNode(String[] inputSequence) {
        Map<String, Integer[]> counter = new HashMap<>();
        for (String node : nodes) {
            Integer[] tuplet = {0, 0};
            counter.put(node, tuplet);
        }
        for (String word : inputSequence) {
            String fl = firstLetterOf(word);
            String ll = lastLetterOf(word);
            Integer[] tmp = counter.get(fl);
            tmp[0]++;
            tmp = counter.get(ll);
            tmp[1]++;
        }
        for (String node : counter.keySet()) {
            if (counter.get(node)[0] > counter.get(node)[1]) {
                return node;
            }
        }
        return "any";
    }

    void findEulerPath(String startNode){
        if(startNode.equals("any")) startNode = nodes.toArray(new String[0])[0];
        vertexStack.push(startNode);
        while (!vertexStack.isEmpty()){
            List<String> currentEdgeList = graph.get(vertexStack.peek());
            if(currentEdgeList.size() > 0){
                edgeStack.push(currentEdgeList.get(0));
                currentEdgeList.remove(0);
                graph.put(vertexStack.peek(), currentEdgeList);
                String currentNode = lastLetterOf(edgeStack.peek());
                vertexStack.push(currentNode);
            } else {
                path.add(vertexStack.pop());
                if(!edgeStack.isEmpty()) result.add(edgeStack.pop());
            }
        }
    }
}
