# MMD Core

## Description

The goal is to create a library that can parse, edit and write various MMD related file formats as Java practice.

## Supported Formats

* emm
* pmx

## Usage

### Parsing

1. Create an instance of the parser for the file format you need and pass a `Path` pointing to the file you wish to parse
2. Call the `parse()` method which will return an instance of the selected file type

### Editing

1. There is a setter for everything

### Writing

1. Create an instance of the parser required for the file format you chose, the constructor takes 2 arguments; the first is an instance of an Object, generally created by the parser, and the second is a boolean to determine whether it is a dryRun
2. Call the `write()` method with a ``Path to write to (in case it is not a dryRun) as the argument