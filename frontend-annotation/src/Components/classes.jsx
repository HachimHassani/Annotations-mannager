
import { useLayoutEffect, useRef, useState } from 'react'
import Navbar from "./Home";
import Sidebar from './sidebar'
import * as React from 'react';
import Box from '@mui/material/Box';
import Modal from '@mui/material/Modal';
import SketchExample from './ColorPickerModal';

const people = [
  {
    id:1,
    name: 'Classe 1',
    Shortkey: 'c3',
    role: 'Member',
    color : 'white'
  },  {
    id:2,
    name: 'Classe 2',
    Shortkey: 'c2',
    role: 'Member',
    color : 'white'

  },
  {
    id:3,
    name: 'Classe 3',
    Shortkey: 'c3',
    role: 'Member',
    color : 'white'

  },
 
  // More people...
]


function classNames(...classes) {
  return classes.filter(Boolean).join(' ')
}

// function Test({ sendDataToParent }){

  
//   const [color,setColor]= useState(   { r: '0',
//   g: '0',
//   b: '0',
//   a: '1'}) 

// const rgb = 'rgb('+color.r+','+color.g+','+color.b+')'
// const divstyle = {
//   'background-color':rgb 
// }
// console.log("this is the rgb ",rgb);
//   const handleCallback =  (childData) => {
//        setColor({r:childData.r,
//         g:childData.g,
//         b:childData.b,
//         a:childData.a,})
//   }

//   const onIndex = (people)=>{ }
  
//   const [open, setOpen] = React.useState(false);
//   const handleOpen = () => setOpen(true);
//   const handleClose = () => {setOpen(false);
//     const divstyle = {
//       'background-color':rgb 
//     }
//     sendDataToParent(divstyle)};
//   const style = {
//       position: 'absolute',
//       top: '50%',
//       left: '50%',
//       transform: 'translate(-50%, -50%)',
//       width: 400,
//       bgcolor: 'background.paper',
//       border: '2px solid #000',
//       boxShadow: 24,
//       p: 4,
//     };


//   return(    
//     <><button onClick={handleOpen} href="#" className="text-indigo-600 hover:text-indigo-900">
//       Edit
//     </button><Modal
//       open={open}
//       onClose={handleClose}
//       aria-labelledby="modal-modal-color"
//       aria-describedby="modal-modal-description"
//     >
//         <Box sx={style}>
//           <div className="pt-8 space-y-6 sm:pt-10 sm:space-y-5">
//             <div>
//               <h3 className="text-lg leading-6 font-medium text-gray-900">Personal Information</h3>
//               <p className="mt-1 max-w-2xl text-sm text-gray-500">Use a permanent address where you can receive mail.</p>
//             </div>
//             <div className="space-y-6 sm:space-y-5">
//               <div className="sm:grid sm:grid-cols-3 sm:gap-4 sm:items-start sm:border-t sm:border-gray-200 sm:pt-5">
//                 <label htmlFor="first-name" className="block text-sm font-medium text-gray-700 sm:mt-px sm:pt-2">
//                   Name
//                 </label>
//                 <div className="mt-1 sm:mt-0 sm:col-span-2">
//                   <input
//                     type="text"
//                     name="first-name"
//                     id="first-name"
//                     autoComplete="given-name"
//                     className="max-w-lg block w-full shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:max-w-xs sm:text-sm border-gray-300 rounded-md" />
//                 </div>
//               </div>

//               <div className="sm:grid sm:grid-cols-3 sm:gap-4 sm:items-start sm:border-t sm:border-gray-200 sm:pt-5">
//                 <label htmlFor="last-name" className="block text-sm font-medium text-gray-700 sm:mt-px sm:pt-2">
//                   Color
//                 </label>
//                 <div className="mt-1 sm:mt-0 sm:col-span-2">
//                   <SketchExample sendDataToParent={handleCallback}></SketchExample>
//                 </div>
//               </div>

//               <div className="sm:grid sm:grid-cols-3 sm:gap-4 sm:items-start sm:border-t sm:border-gray-200 sm:pt-5">
//                 <label htmlFor="last-name" className="block text-sm font-medium text-gray-700 sm:mt-px sm:pt-2">
//                   Shortkey
//                 </label>
//                 <div className="mt-1 sm:mt-0 sm:col-span-2">
//                   <input
//                     type="text"
//                     name="last-name"
//                     id="last-name"
//                     autoComplete="family-name"
//                     className="max-w-lg block w-full shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:max-w-xs sm:text-sm border-gray-300 rounded-md" />
//                 </div>
//               </div>

//               <div className="pt-5">
//                 <div className="flex justify-end">
//                   <button
//                     type="button"
//                     className="bg-white py-2 px-4 border border-gray-300 rounded-md shadow-sm text-sm font-medium text-gray-700 hover:bg-gray-50 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
//                   >
//                     Cancel
//                   </button>
//                   <button
//                     type="submit"
//                     className="ml-3 inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
//                   >
//                     Save
//                   </button>
//                 </div>
//               </div>
//             </div>
//           </div>
//         </Box>
//       </Modal></>)
// }


export default function Classes() {

  const [divs,setDivs] = useState('')
  //console.log(divs);
  const handleTest = (color) => { setDivs(color)}
    const [color,setColor]= useState(   { r: '241',
    g: '112',
    b: '19',
    a: '1'}) 
    const [index,setIndex] = useState(-1)

  const rgb = 'rgb('+color.r+','+color.g+','+color.b+')'
  console.log(rgb)
  const divstyle = {
    'background-color':rgb 
  }
 console.log(index);
    const handleCallback =  (childData) => {
         setColor({r:childData.r,
          g:childData.g,
          b:childData.b,
          a:childData.a,})
    }
    
    const [open, setOpen] = React.useState(false);
    const handleColor = (person,rgb) =>{ setIndex(person.id);person.color=rgb;console.log("this is the id "+person.id+" and this is the color "+person.color)}
    const  handleOpen = () => {setOpen(true)}
    const handleClose = () => setOpen(false);
    const style = {
        position: 'absolute',
        top: '50%',
        left: '50%',
        transform: 'translate(-50%, -50%)',
        width: 400,
        bgcolor: 'background.paper',
        border: '2px solid #000',
        boxShadow: 24,
        p: 4,
      };
  const checkbox = useRef()
  const [checked, setChecked] = useState(false)
  const [indeterminate, setIndeterminate] = useState(false)
  const [selectedPeople, setSelectedPeople] = useState([])

  useLayoutEffect(() => {
    const isIndeterminate = selectedPeople.length > 0 && selectedPeople.length < people.length
    setChecked(selectedPeople.length === people.length)
    setIndeterminate(isIndeterminate)
    checkbox.current.indeterminate = isIndeterminate
  }, [selectedPeople])

  function toggleAll() {
    setSelectedPeople(checked || indeterminate ? [] : people)
    setChecked(!checked && !indeterminate)
    setIndeterminate(false)
  }

  return (
    <div>
        <Navbar></Navbar>
        <Sidebar></Sidebar>
        <div className="px-4 sm:px-6 lg:px-8" style={{marginLeft:301,marginTop:50,marginRight:108}}>

      <div className="sm:flex sm:items-center " >
        <div className="sm:flex-auto">
          <h1 className="text-xl font-semibold text-gray-900">Classes</h1>
          <p className="mt-2 text-sm text-gray-700">
            A list of all classes.
          </p>
        </div>
        <div className="mt-4 sm:mt-0 sm:ml-16 sm:flex-none">
          <button
            type="button"
            className="inline-flex items-center justify-center rounded-md border border-transparent bg-indigo-600 px-4 py-2 text-sm font-medium text-white shadow-sm hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2 sm:w-auto"
          >
            Add a class
          </button>
          
        </div>
      </div>
      <div className="mt-8 flex flex-col">
        <div className="-my-2 -mx-4 overflow-x-auto sm:-mx-6 lg:-mx-8">
          <div className="inline-block min-w-full py-2 align-middle md:px-6 lg:px-8">
            <div className="relative overflow-hidden shadow ring-1 ring-black ring-opacity-5 md:rounded-lg">
              {selectedPeople.length > 0 && (
                <div className="absolute top-0 left-12 flex h-12 items-center space-x-3 bg-gray-50 sm:left-16">
                  <button
                    type="button"
                    className="inline-flex items-center rounded border border-gray-300 bg-white px-2.5 py-1.5 text-xs font-medium text-gray-700 shadow-sm hover:bg-gray-50 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2 disabled:cursor-not-allowed disabled:opacity-30"
                  >
                    Delete all
                  </button>
                </div>
              )}
              <table className="min-w-full table-fixed divide-y divide-gray-300">
                <thead className="bg-gray-50">
                  <tr>
                    <th scope="col" className="relative w-12 px-6 sm:w-16 sm:px-8">
                      <input
                        type="checkbox"
                        className="absolute left-4 top-1/2 -mt-2 h-4 w-4 rounded border-gray-300 text-indigo-600 focus:ring-indigo-500 sm:left-6"
                        ref={checkbox}
                        checked={checked}
                        onChange={toggleAll}
                      />
                    </th>
                    <th scope="col" className="min-w-[12rem]` py-3.5 pr-3 text-left text-sm font-semibold text-gray-900">
                      Name
                    </th>
                    <th scope="col" className="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">
                      Color
                    </th>
                    <th scope="col" className="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">
                      Shortkey
                    </th>
                    <th scope="col" className="relative py-3.5 pl-3 pr-4 sm:pr-6">
                      <span className="sr-only">Edit</span>
                    </th>
                  </tr>
                </thead>
                <tbody className="divide-y divide-gray-200 bg-white">
                  {people.map((person) => (
                    <tr key={person.id}  className={selectedPeople.includes(person) ? 'bg-gray-50' : undefined}>
                      <td className="relative w-12 px-6 sm:w-16 sm:px-8">
                        {selectedPeople.includes(person) && (
                          <div className="absolute inset-y-0 left-0 w-0.5 bg-indigo-600" />
                        )}
                        <input
                          type="checkbox"
                          className="absolute left-4 top-1/2 -mt-2 h-4 w-4 rounded border-gray-300 text-indigo-600 focus:ring-indigo-500 sm:left-6"
                          value={person.Shortkey}
                          checked={selectedPeople.includes(person)}
                          onChange={(e) =>
                            setSelectedPeople(
                              e.target.checked
                                ? [...selectedPeople, person]
                                : selectedPeople.filter((p) => p !== person)
                            )
                          }
                        />
                      </td>
                      <td
                        className={classNames(
                          'whitespace-nowrap py-4 pr-3 text-sm font-medium',
                          selectedPeople.includes(person) ? 'text-indigo-600' : 'text-gray-900'
                        )}
                      >
                        {person.name}
                      </td>
                      <td className="whitespace-nowrap px-3 py-4 text-sm text-gray-500" style = {{backgroundColor:person.color}}>{person.color}</td>
                      <td className="whitespace-nowrap px-3 py-4 text-sm text-gray-500">{person.Shortkey}</td>
                      <td className="whitespace-nowrap py-4 pl-3 pr-4 text-right text-sm font-medium sm:pr-6">
                         <button onClick={()=>{console.log("On edit click",person.id);handleOpen()}} href="#" className="text-indigo-600 hover:text-indigo-900">
                          Edit<span className="sr-only">, {person.name}</span>
                        </button>
                        
                        <button className="text-black-600 hover:text-indigo-900" onClick={()=>{handleColor(person,rgb)}} style = {{marginLeft:48}}>Set Color</button>
                        <Modal
                            open={open}
                            onClose= {()=>{handleClose()}}
                            aria-labelledby="modal-modal-color"
                            aria-describedby="modal-modal-description"
                        >
                            <Box sx={style}>
                            <div className="pt-8 space-y-6 sm:pt-10 sm:space-y-5">
          <div>
            <h3 className="text-lg leading-6 font-medium text-gray-900">Personal Information</h3>
            <p className="mt-1 max-w-2xl text-sm text-gray-500">Use a permanent address where you can receive mail.</p>
          </div>
          <div className="space-y-6 sm:space-y-5">
            <div className="sm:grid sm:grid-cols-3 sm:gap-4 sm:items-start sm:border-t sm:border-gray-200 sm:pt-5">
              <label htmlFor="first-name" className="block text-sm font-medium text-gray-700 sm:mt-px sm:pt-2">
                Name
              </label>
              <div className="mt-1 sm:mt-0 sm:col-span-2">
                <input
                  type="text"
                  name="first-name"
                  id="first-name"
                  autoComplete="given-name"
                  className="max-w-lg block w-full shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:max-w-xs sm:text-sm border-gray-300 rounded-md"
                />
              </div>
            </div>

            <div className="sm:grid sm:grid-cols-3 sm:gap-4 sm:items-start sm:border-t sm:border-gray-200 sm:pt-5">
              <label htmlFor="last-name" className="block text-sm font-medium text-gray-700 sm:mt-px sm:pt-2">
                Color
              </label>
              <div className="mt-1 sm:mt-0 sm:col-span-2">
              <SketchExample sendDataToParent = {handleCallback}></SketchExample>
              </div>
            </div>

            <div className="sm:grid sm:grid-cols-3 sm:gap-4 sm:items-start sm:border-t sm:border-gray-200 sm:pt-5">
              <label htmlFor="last-name" className="block text-sm font-medium text-gray-700 sm:mt-px sm:pt-2">
              Shortkey
              </label>
              <div className="mt-1 sm:mt-0 sm:col-span-2">
                <input
                  type="text"
                  name="last-name"
                  id="last-name"
                  autoComplete="family-name"
                  className="max-w-lg block w-full shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:max-w-xs sm:text-sm border-gray-300 rounded-md"
                />
              </div>
            </div>

            <div className="pt-5">
        <div className="flex justify-end">
          <button
            type="button"
            className="bg-white py-2 px-4 border border-gray-300 rounded-md shadow-sm text-sm font-medium text-gray-700 hover:bg-gray-50 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
          >
            Cancel
          </button>
          <button
            type="submit"
            className="ml-3 inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
          >
            Save
          </button>
        </div>
      </div>
          </div>
        </div>
                            </Box>
                        </Modal> 
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
    </div>


  )
}
