#!/usr/bin/env python3


from fileinput import input
from collections import deque


class Vertex:
    def __init__(self, name):
        self.name = name
        self.edges = {}
        self.state = 'blank'


class Graph:
    def __init__(self, vertex_names, named_edges):
        self.vertices = dict(zip(vertex_names, map(Vertex, vertex_names)))

        for u, v in named_edges:
            self.vertices[u].edges[v] = self.vertices[v]

    def topo_sort(self):
        result = deque()

        for vertex_name in self.vertices.keys():
            u = self.vertices[vertex_name]

            if u.state == 'blank':
                if not self.dfs(u, result):
                    return ('impossible',)

        return result

    def dfs(self, vertex, memo):
        if vertex.state == 'pending':
            return False

        if vertex.state == 'blank':
            vertex.state = 'pending'
            for v in vertex.edges.values():
                if not self.dfs(v, memo):
                    return False

            vertex.state = 'complete'
            memo.appendleft(vertex.name)

        return True


if __name__ == '__main__':
    input_lines = tuple(map(lambda x: x.strip().split(' '), input()))
    g = Graph(input_lines[0], input_lines[1:])
    print('\n'.join(g.topo_sort()))
