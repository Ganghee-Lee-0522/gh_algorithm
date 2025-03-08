#include <bits/stdc++.h>

using namespace std;

void quickSort(int i, int j, vector<int>& arr) {
        if(i >= j) return;
        
        int pivot = arr[(i + j) / 2];
        int left = i, right = j;
        
        while(left <= right) {
            while(arr[left] < pivot) left++;
            while(arr[right] > pivot) right--;
            if(left <= right) {
                swap(arr[left], arr[right]);
                left++; 
                right--;
            }
        }
        quickSort(i, right, arr);
        quickSort(left, j, arr);
}

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    int times = commands.size();
    for(int idx = 0; idx < times; idx++) {
        // cout << commands[idx][0] - 1 << ' ' << tmp[commands[idx][0] - 1] << ' ' << tmp[commands[idx][1] - 1] << '\n';
        // cout << "tmp: ";
        // for(int p : tmp) {
        //     cout << p << ' ';
        // }
        // cout << '\n';
        vector<int> tmp = array;
        // array[]의 commands[idx][0] - 1 인덱스부터 commands[idx][1] - 1 인덱스까지 정렬
        quickSort(commands[idx][0] - 1, commands[idx][1] - 1, tmp);
        // 정렬된 array[]의 commands[idx][0] - 1 + commands[idx][2] - 1 인덱스의 원소를 정답에 추가
        answer.push_back(tmp[commands[idx][0] + commands[idx][2] - 2]);
    }
    return answer;
}