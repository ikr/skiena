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
        self.withoutIncoming = set(vertex_names)
        self.vertices = dict(zip(vertex_names, map(Vertex, vertex_names)))

        for u, v in named_edges:
            self.vertices[u].edges[v] = self.vertices[v]
            self.vertices[v].incomingCount += 1
            self.withoutIncoming.discard(v)

    def remove(self, vertex_names):
        for u in vertex_names:
            self.withoutIncoming.remove(u)

            for v in self.vertices[u].edges.keys():
                self.vertices[v].incomingCount -= 1
                if self.vertices[v].incomingCount == 0:
                    self.withoutIncoming.add(v)

            del self.vertices[u]


if __name__ == '__main__':
    input_lines = tuple(map(lambda x: x.strip().split(' '), input()))
    g = Graph(input_lines[0], input_lines[1:])

    while g.vertices:
        if not g.withoutIncoming:
            print('impossible')
            break

        print('\n'.join(g.withoutIncoming))
        g.remove(tuple(g.withoutIncoming))
