# Building a Learning Model

i.) Find Best representation of data (BiGrams/Patterns, csv, JSON)
   - Use statistical modeling or number theory to find approach.


_We picked BiGram model because we want the highest probability of next character.
We then remove <\S>,<\E> characters to minimize matrix and replace them with a period to signal the end of a word or the start of a new word._

ii.) Visualize dataset

- a matrix
- vector
- or curve, i.e 'some f(x)'

_Note: remove noise / redundancy,  ex: remove redundant row@col in BiGram matrix_
```python
# With <S>, <E>
# for word in words:
#     chs = ['<S>'] + list(word) + ['<E>']
#     for char1, char2 in zip(chs, chs[1:]):
#         ix1 = char_to_index[char1]
#         ix2 = char_to_index[char2]
#         char_to_count_matrix[ix1, ix2] += 1
# With <S> row. 
# With only <.> as terminator
for word in words:
    chs = ['.'] + list(word) + ['.']
    for char1, char2 in zip(chs, chs[1:]):
        ix1 = char_to_index[char1]
        ix2 = char_to_index[char2]
        char_to_count_matrix[ix1, ix2] += 1
```
 
\
iv.) normalize data (probabilities, probabilities, probabilities)
- do we normalize in all cases after visualization?
- softmax function = e^z_i / from j->k sum(e^z_j) aka 'normalization function'

\
v.) TEST TIME: sample data
- forward pass? Run neural net
- backward pass? Find out which weight (w) affected the decesion the most
- update weights (w), coefficients?
- smooth model / *move towards uniformity; ex: add pseudo/seed number to each choice to remove chance probability of zero.

\
vi.) remove loss and back-propagate: move choice against/away or minimize gradient
- in BiGram (classification) 
  - Manual Implementation:
    - log likelihood = log(prob), 
    - negative log -log(prob) 
    - loss -> p = -nll/n,
  - Pytorch
    - Cross-Entropy
-  mean-squared-error (regression), 

\
vii.) optimize ? 
- gradient based optimization: change over time (vector gradient)
  - For nueral network BiGram model we used W.data+=-10*W.grad. why? this equation?
- how to determine learning rate? (-0.1*p.grad)
- how to 'smartly' introduce gradient decay

\
viii.) train,dev,test splits = 80/10/10

w = 

what is forward pass? in BiGram we:
- 1hot encoded an array of zeros
- 
1. Inputs 
   i. In BiGram model inputs are 1 character
   ii. vector in neural network 
2. Weights
3. Functions
4. Smoothing
5. Loss function and learning
   6. Regularization loss
   7. Loss smoothing
5. Output