static class SuffixAutomaton {
        int[]link,len;
        HashMap<Character,Integer>[]next;
        int lst,idx;

        SuffixAutomaton(char[]s) {
            int n=s.length;
            link=new int[n<<1];
            len=new int[n<<1];
            next=new HashMap[n<<1];
            next[0]=new HashMap<>();
            for(char c:s)
                addLetter(c);
        }

        void addLetter(char c) {
            int cur=++idx,p=lst;
            while(!next[p].containsKey(c)){
                next[p].put(c,cur);
                p=link[p];
            }
            int q=next[p].get(c);
            if(q!=cur)
                if(len[q]==len[p]+1)
                    link[cur]=q;
                else{
                    int clone=++idx;
                    len[clone]=len[p]+1;
                    link[clone]=link[q];
                    next[clone]= new HashMap<>(next[q]);
                    link[cur]=link[q]=clone;
                    while(next[p].get(c)==q) {
                        next[p].put(c,clone);
                        p=link[p];
                    }
                }
            len[cur]=len[lst]+1;
            next[cur]=new HashMap<>();
            lst=cur;
        }
    }
