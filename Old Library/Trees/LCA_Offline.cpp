const int MAXN = максимальное число вершин в графе;
vector<int> g[MAXN], q[MAXN]; // Graph & Queries
int dsu[MAXN], ancestor[MAXN];
bool u[MAXN];
 
int dsu_get (int v) {
	return v == dsu[v] ? v : dsu[v] = dsu_get (dsu[v]);
}
 
void dsu_unite (int a, int b, int new_ancestor) {
	a = dsu_get (a),  b = dsu_get (b);
	if (rand() & 1)  swap (a, b);
	dsu[a] = b,  ancestor[b] = new_ancestor;
}
 
void dfs (int v) {
	dsu[v] = v,  ancestor[v] = v;
	u[v] = true;
	for (size_t i=0; i<g[v].size(); ++i)
		if (!u[g[v][i]]) {
			dfs (g[v][i]);
			dsu_unite (v, g[v][i], v);
		}
	for (size_t i=0; i<q[v].size(); ++i)
		if (u[q[v][i]]) {
			printf ("%d %d -> %d\n", v+1, q[v][i]+1,
				ancestor[ dsu_get(q[v][i]) ]+1);
}
 
int main() {
	... чтение графа ...
 
	// чтение запросов
	for (;;) {
		int a, b = ...; // Query
		--a, --b;
		q[a].push_back (b);
		q[b].push_back (a);
	}
 
	// обход в глубину и ответ на запросы
	dfs (0);
}
