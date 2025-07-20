// Need a hashmap + array to achieve all three operations in constant time on average. Need an array to get a random index, and we need a hashmap for constant time removal which we'll use to track indices of elements so that we can lookup the index for a specific value, switch it with the last element, then remove that last element in constant time to avoid shifting elements.
class RandomizedSet {
public:
    RandomizedSet() : engine_(std::random_device{}()) {}
    
    bool insert(int val) {
        if (map_.count(val)) return false;
        array_.push_back(val);
        map_[val] = array_.size() - 1;
        return true;
    }
    
    bool remove(int val) {
        if (!map_.count(val)) return false;

        int valIdx = map_[val];
        int last = array_.back();
        
        array_[valIdx] = last;
        map_[last] = valIdx;

        array_.pop_back();
        map_.erase(val);

        return true;
    }
    
    int getRandom() {
        std::uniform_int_distribution<int> dist(0, array_.size() - 1);
        return array_[dist(engine_)];
    }
private:
    std::mt19937 engine_;
    std::unordered_map<int, int> map_;
    std::vector<int> array_;
};
