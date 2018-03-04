#!/usr/bin/env python3


from fileinput import input


class Vertex:
    def __init__(self, name):
        self.name = name
        self.edges = {}
        self.incomingCount = 0

    def __repr__(self):
        return str({
            'edges': tuple(map(lambda v: v.name, self.edges.values())),
            'incomingCount': self.incomingCount
        })


class Graph:
    def __init__(self, vertex_names, named_edges):
        self.vertices = dict(zip(vertex_names, map(Vertex, vertex_names)))

        for u, v in named_edges:
            self.vertices[u].edges[v] = self.vertices[v]
            self.vertices[v].incomingCount += 1


if __name__ == '__main__':
    input_lines = tuple(map(lambda x: x.strip().split(' '), input()))

    print(Graph(input_lines[0], input_lines[1:]).vertices)
