#version 140

in vec2 position;
in mat4 transformationMatrix;
in vec2 texOffsets;

out vec2 pass_textureCoords;

uniform float numRows;

void main(void) {

	vec2 textureCoords = vec2((position.x+1.0)/2.0, 1 - (position.y+1.0)/2.0);
    textureCoords /= numRows;
    pass_textureCoords = textureCoords + texOffsets;

    gl_Position = transformationMatrix * vec4(position, 0.0, 1.0);

}