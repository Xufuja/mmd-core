package dev.xfj.format.pmx;

public class PMXFileVertexIndex {
    private int vertexIndex1;
    private int vertexIndex2;
    private int vertexIndex3;

    public PMXFileVertexIndex(int vertexIndex1, int vertexIndex2, int vertexIndex3) {
        this.vertexIndex1 = vertexIndex1;
        this.vertexIndex2 = vertexIndex2;
        this.vertexIndex3 = vertexIndex3;
    }

    public int getVertexIndex1() {
        return vertexIndex1;
    }

    public void setVertexIndex1(int vertexIndex1) {
        this.vertexIndex1 = vertexIndex1;
    }

    public int getVertexIndex2() {
        return vertexIndex2;
    }

    public void setVertexIndex2(int vertexIndex2) {
        this.vertexIndex2 = vertexIndex2;
    }

    public int getVertexIndex3() {
        return vertexIndex3;
    }

    public void setVertexIndex3(int vertexIndex3) {
        this.vertexIndex3 = vertexIndex3;
    }
}
